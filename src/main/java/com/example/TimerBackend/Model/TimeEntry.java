package com.example.TimerBackend.Model;

import com.example.TimerBackend.Model.User;
import jakarta.persistence.*;

@Entity
public class TimeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clockInTime;
    private String clockOutTime;
    private String timer;

    @ManyToOne
    @JoinColumn(name = "user_id")  // FK
    private User user;

    public TimeEntry() {}
    public TimeEntry(String clockInTime, String clockOutTime, String timer, User user) {
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
        this.timer = timer;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(String clockInTime) {
        this.clockInTime = clockInTime;
    }

    public String getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(String clockOutTime) {
        this.clockOutTime = clockOutTime;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
