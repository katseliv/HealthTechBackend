package team.healthtech.service.logic.impl;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.db.repository.DoctorRepository;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.mapper.TimeRecordMapper;
import team.healthtech.service.model.TimeRecordDto;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeRecordServiceImpl implements TimeRecordService {

    private final TimeRecordsRepository repository;
    private final TimeRecordMapper mapper;
    private final DoctorRepository doctorRepository;

    public TimeRecordServiceImpl(TimeRecordsRepository repository, TimeRecordMapper mapper, DoctorRepository doctorRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public TimeRecordDto createTimeRecord(TimeRecordDto dto) throws Exception {
        TimeRecordEntity targetEntity = mapper.toEntity(dto);

        DoctorEntity doctor = doctorRepository.findById(dto.getDoctorId()).orElseThrow();
        targetEntity.setDoctor(doctor);
        for (TimeRecordEntity tr :
            repository.getTimeRecordEntitiesByDoctorId(doctor.getId())) {
            if (tr.getDate().compareTo(targetEntity.getDate()) < 0)
                throw new Exception();
        }
        TimeRecordEntity result = repository.save(targetEntity);
        TimeRecordDto timeRecordDto = mapper.fromEntity(result);
        timeRecordDto.setDoctorId(doctor.getId());
        return timeRecordDto;
    }

    @Override
    public void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId) {
        //timeRecordDto.setId(repository.findById(timeRecordsId).orElseThrow().getId());
        TimeRecordEntity entity = repository.findById(timeRecordsId).orElseThrow();
        mapper.merge(timeRecordDto, entity);
        entity.setId(timeRecordsId);
        entity.setDoctor(doctorRepository.findById(timeRecordDto.getDoctorId()).orElseThrow());

        repository.save(entity);
    }

    @Override
    public void deleteTimeRecord(int timeRecordId) {
        repository.deleteById(timeRecordId);
    }

    @Override
    public TimeRecordDto getTimeRecordByDoctorId(Date date, Integer doctorId) {
        TimeRecordEntity e = repository.getTimeRecordEntityByDateAndDoctorId(date, doctorId);
        TimeRecordDto timeRecordDto = mapper.fromEntity(e);
        timeRecordDto.setDoctorId(doctorId);
        return timeRecordDto;
    }

    @Override
    public List<TimeRecordDto> getScheduleByDatesAndDoctorId(List<Date> dates, Integer doctorId) {
        List<TimeRecordEntity> list = new ArrayList<>();
        for (Date d : dates) {
            TimeRecordEntity e = repository.getTimeRecordEntityByDateAndDoctorId(d, doctorId);
            list.add(e);
        }
        List<TimeRecordDto> resultList = mapper.fromEntities(list);
        for (TimeRecordDto dto :
            resultList) {
            dto.setDoctorId(doctorId);
        }
        return resultList;
    }
}
