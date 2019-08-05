package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRespository extends JpaRepository<Track,Integer> {
    //reequesting data through queries
    //query to get through name
    @Query (value = "select t from Track t where t.name = ?1",nativeQuery = true)
    Track getTrackByName(String name);

}
