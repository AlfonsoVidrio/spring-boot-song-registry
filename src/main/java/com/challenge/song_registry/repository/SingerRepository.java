package com.challenge.song_registry.repository;

import com.challenge.song_registry.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingerRepository extends JpaRepository<Singer, Long> {
    List<Singer> findByNameContainsIgnoreCase(String name);
}
