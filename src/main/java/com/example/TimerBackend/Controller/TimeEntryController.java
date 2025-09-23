package com.example.TimerBackend.Controller;

import com.example.TimerBackend.Model.BreakEntry;
import com.example.TimerBackend.Model.TimeEntry;
import com.example.TimerBackend.Model.User;
import com.example.TimerBackend.Repository.BreakEntryRepository;
import com.example.TimerBackend.Repository.TimeEntryRepository;
import com.example.TimerBackend.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/timer")
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeRepo;
    @Autowired
    private UserRepository userRepo;

    /* @Autowired
     private BreakEntryRepository breakRepo;

     @PostMapping("/clock-in")
     public TimeEntry clockIn() {
         entry.setClockInTime(LocalDateTime.now()); // current time
         timeRepo.save(entry);
         return entry;
     }
     @PostMapping("/break-in")
     public TimeEntry breakIn() {

         breakEntry.setBreakInTime(LocalDateTime.now());
         breakEntry.setAttendance(entry);
         breakRepo.save(breakEntry);
         return entry;
     }
     @PostMapping("/break-out")
     public TimeEntry breakOut() {
         breakEntry.setBreakOutTime(LocalDateTime.now()); // current time
         breakRepo.save(breakEntry);
         breakEntry.setAttendance(entry);
         return entry;
     }*/
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    @PostMapping("/clock-out/{userId}")
    public TimeEntry clockOut(@PathVariable Long userId, @RequestBody TimeEntry timeEntry) {
        User user = userRepo.findById(userId).orElseThrow();
        TimeEntry entry = new TimeEntry(timeEntry.getClockInTime(),
                timeEntry.getClockOutTime(),
                timeEntry.getTimer(),
                user);
        return timeRepo.save(entry);
    }
}
