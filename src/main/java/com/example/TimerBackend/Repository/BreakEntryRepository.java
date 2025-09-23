package com.example.TimerBackend.Repository;

import com.example.TimerBackend.Model.BreakEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreakEntryRepository extends JpaRepository<BreakEntry, Long> {
}
