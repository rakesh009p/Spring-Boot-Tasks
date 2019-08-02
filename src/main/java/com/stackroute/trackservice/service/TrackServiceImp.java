package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if(trackRespository.existsById(track.getId()))
        {
            System.out.println("Inside service*************");
            throw new TrackAlreadyExistException("user already exists");
        }
        Track savedTrack = trackRespository.save(track);
        if(savedTrack==null){
            throw new TrackAlreadyExistException("user already exists");
        }
        return savedTrack;
    }

    @Override
    public Optional<Track> getTrackById(int id) throws TrackNotFoundException {
       if( !trackRespository.findById(id).isPresent()){

            throw  new TrackNotFoundException("id not exists");
        }
        return trackRespository.findById(id);
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        List<Track> trackList = trackRespository.findAll();
        if(trackList.isEmpty()){
            throw new TrackNotFoundException("Tracks Not available");
        }
        return trackList;
    }

    @Override
    public Track getTrackByName(String name) throws TrackNotFoundException {


        Track trackName = trackRespository.getTrackByName(name);
        if(trackName==null){
            throw  new TrackNotFoundException("name not exists");
        }
        return trackName;

    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        Optional<Track> trackDelete = trackRespository.findById(id);
        if (!trackDelete.isPresent()) {
            throw  new TrackNotFoundException("track not found");
        }
        else{
        trackRespository.deleteById(id);}

        return trackDelete;
    }

    @Override
    public Track updateTrack(int id, Track track) {
        Track update = trackRespository.findById(id).get();
        update.setName(track.getName());
        update.setComment(track.getComment());
        return trackRespository.save(track);
    }
}
