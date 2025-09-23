package com.example.TimerBackend.DTO;

import com.example.TimerBackend.Model.TimeEntry;
import com.example.TimerBackend.Model.User;

public class userResponse {
    private final Long id;
    private final String username;
    private final String lastClockInDate;

    public userResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.lastClockInDate = extractLatestClockIn(user);
    }

    private String extractLatestClockIn(User user) {
        if (user.getTimeEntries() == null || user.getTimeEntries().isEmpty()) return null;

        // Get last TimeEntry
        TimeEntry lastEntry = user.getTimeEntries().get(user.getTimeEntries().size() - 1);
        String clockInTime = lastEntry.getClockInTime();

            return clockInTime;

    }

    // getters
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getLastClockInDate() { return lastClockInDate; }
}
