package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class TrackController {
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> setTrack(@RequestBody Track track) {
        System.out.println(track);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println(savedTrack);

        return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);

    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@RequestParam int id) {
        Track trackId = trackService.getTrackById(id);
        return new ResponseEntity<>(trackId, HttpStatus.OK);
    }

    @GetMapping("tracks/")
    public ResponseEntity<?> getAllTracks() {
        List<Track> trackAll = trackService.getAllTracks();
        return new ResponseEntity<>(trackAll, HttpStatus.OK);
    }

    @DeleteMapping("trackde/{id}")
    public ResponseEntity<?> deleteTrackbyId(@PathVariable int id) {
        Optional<Track> trackDelete = (Optional<Track>) trackService.deleteTrackById(id);

        return new ResponseEntity<>(trackDelete, HttpStatus.CREATED);
    }


    @PutMapping("trackco/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
        Track updatedTrack=trackService.updateTrack(id,track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
    }

