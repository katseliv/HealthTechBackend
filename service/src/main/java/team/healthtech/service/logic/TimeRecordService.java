package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.TimeRecordDto;

import javax.validation.Valid;
import java.util.List;

public interface TimeRecordService {

    TimeRecordDto createTimeRecord(@Valid TimeRecordDto dto);

    void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId);

    void deleteTimeRecord(int timeRecordId);

}
