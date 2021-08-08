package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.mapper.TimeRecordMapper;
import team.healthtech.service.model.TimeRecordDto;
import team.healthtech.service.security.Profile;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class TimeRecordServiceImpl implements TimeRecordService {

    private static final Logger logger = LoggerFactory.getLogger(TimeRecordServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final TimeRecordsRepository repository;
    private final TimeRecordMapper mapper;

    public TimeRecordServiceImpl(
        ObjectProvider<Profile> profileProvider,
        TimeRecordsRepository repository,
        TimeRecordMapper mapper
    ) {
        this.profileProvider = profileProvider;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TimeRecordDto createTimeRecord(@Valid TimeRecordDto dto) {
        return Optional.ofNullable(dto)
            .map(mapper::toEntity)
            .map(repository::save)
            .map(mapper::fromEntity)
            .orElseThrow();
    }

    @Override
    public void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId) {
        logger.info("Time record with id {} update request by {}", timeRecordsId, profileProvider.getIfAvailable());
        mapper.merge(timeRecordDto, repository.findById(timeRecordsId).orElseThrow());
        repository.save(mapper.toEntity(timeRecordDto));
    }

    @Override
    public void deleteTimeRecord(int timeRecordId) {
        logger.info("Time record with id {} delete request by {}", timeRecordId, profileProvider.getIfAvailable());
        repository.deleteById(timeRecordId);
    }

}
