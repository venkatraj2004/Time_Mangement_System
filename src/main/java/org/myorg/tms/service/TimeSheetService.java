package org.myorg.tms.service;


import org.myorg.tms.Status;
import org.myorg.tms.entity.Employee;
import org.myorg.tms.entity.TimeSheet;
import org.myorg.tms.repository.EmployeeRepository;
import org.myorg.tms.repository.TimeSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSheetService {

    @Autowired
    private TimeSheetRepository timeSheetRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. Add Time Entry
    public TimeSheet addTimeEntry(Long userId, TimeSheet timeSheet) {
        Employee employee = employeeRepository.findById(userId).orElseThrow();

        timeSheet.setEmployee(employee);
        timeSheet.setStatus(Status.PENDING);

        return timeSheetRepository.save(timeSheet);
    }

    // 2. Get My Entries
    public List<TimeSheet> getMyEntries(Long userId) {
        return timeSheetRepository.findByEmployeeId(userId);
    }

    // 3. Get Team Entries (Manager)
    public List<TimeSheet> getTeamEntries(Long managerId) {
        List<Employee> employees = employeeRepository.findByManagerId(managerId);
        List<Long> empIds = employees.stream().map(Employee::getId).toList();

        return timeSheetRepository.findByEmployeeIdIn(empIds);
    }


}
