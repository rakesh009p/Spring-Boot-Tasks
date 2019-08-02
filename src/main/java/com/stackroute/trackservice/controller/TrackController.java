package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
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
    //save track

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            System.out.println("Inside controller**********");
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("sucessfully ceated", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("*****" + e.toString());
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.getTrackById(id);
            responseEntity = new ResponseEntity<String>("retrived by id", HttpStatus.CREATED);
        } catch (TrackNotFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;

    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        try {
            trackService.getAllTracks();
            responseEntity = new ResponseEntity("Retreived All Tracks", HttpStatus.OK);
        } catch (TrackNotFoundException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }

    //getting data using getByName using getMapping
    @GetMapping("trackse/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable String name) {
        ResponseEntity responseEntity;
        try {
            trackService.getTrackByName(name);
            responseEntity = new ResponseEntity<String>("retrived by name", HttpStatus.CREATED);
        } catch (TrackNotFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;

    }


    @DeleteMapping("trackde/{id}")
    public ResponseEntity<?> deleteTrackbyId(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            trackService.deleteTrackById(id);
            responseEntity = new ResponseEntity<String>("deleted by id", HttpStatus.CREATED);
        } catch (TrackNotFoundException e) {

            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }


    @PutMapping("trackco/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @RequestBody Track track) {
        Track updatedTrack = trackService.updateTrack(id, track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }
}

