package org.myorg.tms.controller;

import org.myorg.tms.Status;
import org.myorg.tms.entity.TimeSheet;
import org.myorg.tms.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
@CrossOrigin
public class TimeSheetController {

    @Autowired
    private TimeSheetService timeSheetService;

    // 1. Add Entry
    @PostMapping("/{userId}")
    public TimeSheet addEntry(@PathVariable Long userId,
                              @RequestBody TimeSheet timeSheet) {
        return timeSheetService.addTimeEntry(userId, timeSheet);
    }

    // 2. Get My Entries
    @GetMapping("/my/{userId}")
    public List<TimeSheet> getMyEntries(@PathVariable Long userId) {
        return timeSheetService.getMyEntries(userId);
    }

    // 3. Get Team Entries
    @GetMapping("/team/{managerId}")
    public List<TimeSheet> getTeamEntries(@PathVariable Long managerId) {
        return timeSheetService.getTeamEntries(managerId);
    }

}
