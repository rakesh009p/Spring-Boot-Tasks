package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public class TrackDummyServiceImpl implements TrackService {
    @Override
    public Track saveTrack(Track user) throws TrackAlreadyExistException {
        return null;
    }

    @Override
    public Optional<Track> getTrackById(int id) throws TrackNotFoundException {
        return Optional.empty();
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {
        return null;
    }

    @Override
    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
        return Optional.empty();
    }

    @Override
    public Track updateTrack(int id, Track track) {
        return null;
    }

    @Override
    public Track getTrackByName(String name) throws TrackNotFoundException {
        return null;
    }
}
