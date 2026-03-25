package org.myorg.tms.repository;

import org.myorg.tms.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {
    List<TimeSheet> findByEmployeeId(Long employeeId);

    List<TimeSheet> findByEmployeeIdIn(List<Long> employeeIds);
}
