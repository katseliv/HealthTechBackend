package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.db.repository.DoctorRepository;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.mapper.TimeRecordMapper;
import team.healthtech.service.model.TimeRecordDto;

import java.sql.Date;
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
    public TimeRecordDto createTimeRecord(TimeRecordDto dto) {
        TimeRecordEntity entity = mapper.toEntity(dto);
        DoctorEntity doctor = doctorRepository.findById(dto.getDoctorId()).orElseThrow();
        entity.setDoctor(doctor);
        TimeRecordEntity result = repository.save(entity);
        TimeRecordDto timeRecordDto = mapper.fromEntity(result);
        timeRecordDto.setDoctorId(doctor.getId());
        return timeRecordDto;
    }

    @Override
    public void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId) {
        mapper.merge(timeRecordDto, repository.findById(timeRecordsId).orElseThrow());
        repository.save(mapper.toEntity(timeRecordDto));
    }

    @Override
    public void deleteTimeRecord(int timeRecordId) {
        repository.deleteById(timeRecordId);
    }

    @Override
    public TimeRecordDto getTimeRecordByDoctorId(Date date, Integer doctorId) {
        TimeRecordEntity e = repository.getTimeRecordEntityByDateAndDoctorId(date, doctorId);
        return mapper.fromEntity(e);
    }

    @Override
    public List<TimeRecordDto> getScheduleByDatesAndDoctorId(List<Date> dates, Integer doctorId) {
        List<TimeRecordEntity> list = new ArrayList<>();
        for (Date d : dates) {
            TimeRecordEntity e = repository.getTimeRecordEntityByDateAndDoctorId(d, doctorId);
            list.add(e);
        }
        return mapper.fromEntities(list);
    }
}
