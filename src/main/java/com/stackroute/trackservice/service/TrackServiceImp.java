package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImp implements TrackService {

    TrackRespository trackRespository;


    @Autowired
    public TrackServiceImp(TrackRespository trackRespository) {
        this.trackRespository = trackRespository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track savedTrack = trackRespository.save(track);
        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) {
        Track trackId = trackRespository.findById(id).get();
        return trackId;
    }

    @Override
    public List<Track> getAllTracks() {
        List<Track> trackList = trackRespository.findAll();
        return trackList;

    }

    @Override
    public Optional<Track> deleteTrackById(int id) {
        Optional<Track> trackDelete = trackRespository.findById(id);
        if (trackDelete.isPresent()) {
            trackRespository.deleteById(id);
        }
        return trackDelete;
    }

    @Override
    public Track updateTrack(int id,Track track) {
        Track update = trackRespository.findById(id).get();
        update.setName(track.getName());
        update.setComment(track.getComment());
        return trackRespository.save(track);
    }
}
