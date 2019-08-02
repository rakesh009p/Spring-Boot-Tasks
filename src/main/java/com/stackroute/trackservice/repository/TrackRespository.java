package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRespository extends JpaRepository<Track,Integer> {
}
