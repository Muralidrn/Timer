package com.example.TimerBackend.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BreakEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime breakInTime;
    private LocalDateTime breakOutTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendance_id")
    private TimeEntry attendance;

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getBreakInTime() { return breakInTime; }
    public void setBreakInTime(LocalDateTime breakInTime) { this.breakInTime = breakInTime; }

    public LocalDateTime getBreakOutTime() { return breakOutTime; }
    public void setBreakOutTime(LocalDateTime breakOutTime) { this.breakOutTime = breakOutTime; }

    public TimeEntry getAttendance() { return attendance; }
    public void setAttendance(TimeEntry attendance) { this.attendance = attendance; }
}
