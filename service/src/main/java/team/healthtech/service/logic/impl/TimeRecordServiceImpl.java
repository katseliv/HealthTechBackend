package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.mapper.TimeRecordMapper;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.TimeRecordDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TimeRecordServiceImpl implements TimeRecordService {
    private final TimeRecordsRepository repository;
    private final TimeRecordMapper mapper;

    public TimeRecordServiceImpl(TimeRecordsRepository repository, TimeRecordMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TimeRecordDto createTimeRecord(TimeRecordDto dto) {
        return Optional.ofNullable(dto)
            .map(mapper::toEntity)
            .map(repository::save)
            .map(mapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId) {
        mapper.merge(timeRecordDto, repository.findById(timeRecordsId).orElseThrow());
        repository.save(mapper.toEntity(timeRecordDto));
    }

    @Override
    public void deleteTimeRecordsByDoctorId(int doctorId) {
        // don't know what I'm actually doing
        // cannot delete items of collection simultaneously with foreach
        /*
        repository.findAll().forEach(timeRecordEntity -> {
            if (timeRecordEntity.getDoctor().getId() == doctorId)
                repository.deleteById(timeRecordEntity.getId());
        });
         */
        Iterator<TimeRecordEntity> iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            var item = iterator.next();
            if (item.getDoctor().getId() == doctorId)
                repository.deleteById(item.getId());
        }
    }

    @Override
    public void deleteTimeRecord(int timeRecordId) {
        repository.deleteById(timeRecordId);
    }
}
