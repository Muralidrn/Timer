package com.example.TimerBackend.Repository;


import com.example.TimerBackend.Model.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
}
