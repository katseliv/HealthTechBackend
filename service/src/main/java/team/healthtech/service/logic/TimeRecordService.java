package team.healthtech.service.logic;

import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.TimeRecordDto;

import java.util.List;

public interface TimeRecordService {

    TimeRecordDto createTimeRecord(TimeRecordDto dto);

    void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId);

    void deleteTimeRecord(int timeRecordId);

}
