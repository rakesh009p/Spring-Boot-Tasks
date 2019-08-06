package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRespository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    Track track;

    //Create a mock for UserRepository
    @Mock
    TrackRespository trackRespository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    TrackServiceImp trackServiceImp;


    private List<Track> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(19);
        track.setName("rakesh");
        track.setComment("i am rakesh");
        list = new ArrayList<>();
        list.add(track);


    }


    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistException {
        when(trackRespository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackServiceImp.saveTrack(track);
        Assert.assertEquals(track, savedTrack);
        //verify here verifies that userRepository save method is only called once
        verify(trackRespository, times(1)).save(track);
    }


    @Test
    public void getTrackById() throws TrackNotFoundException {

        when(trackRespository.findById(track.getId())).thenReturn(Optional.of(track));
//        when(trackRespository.save(track)).thenReturn(track);
        Track savedTrack = trackServiceImp.getTrackById(track.getId()).get();
        Assert.assertEquals(track, savedTrack);
        //verify here verifies that userRepository save method is only called once
        verify(trackRespository, times(2)).findById(track.getId());
    }

    @Test(expected = TrackAlreadyExistException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistException {
        when(trackRespository.save((Track) any())).thenReturn(null);
        Track savedUser = trackServiceImp.saveTrack(track);
        System.out.println("savedUser" + savedUser);
        //Assert.assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }


    @Test
    public void getAllTracks() throws TrackNotFoundException {

        trackRespository.save(track);
        //stubbing the mock to return specific data
        when(trackRespository.findAll()).thenReturn(list);
        List<Track> userlist = trackServiceImp.getAllTracks();
        Assert.assertEquals(list, userlist);
    }

    @Test
    public void getByName() throws TrackNotFoundException {
        trackRespository.save(track);
        when(trackRespository.findByName("rakesh")).thenReturn(track);
        Track trackName = trackServiceImp.getByName(track.getName());
        Assert.assertEquals(track, trackName);
    }


    @Test
    public void deleteTrackById() throws TrackNotFoundException {
        when(trackRespository.findById(19)).thenReturn(Optional.of(track));
        Optional<Track> trackDelete = trackServiceImp.deleteTrackById(19);
        Assert.assertEquals(track, trackDelete.get());
    }

    @Test
    public void updateTrackTestSuccess(){
        trackRespository.save(track);
        Track track1 = new Track();
        track1.setName("rock n roll");
        track1.setComment("Best Track");
        when(trackRespository.findById(track.getId())).thenReturn(Optional.of(track));
        Track updateTrack =  trackServiceImp.updateTrack(19,track1);
        when(trackRespository.save(updateTrack)).thenReturn(updateTrack);
        Assert.assertNotEquals(updateTrack,track);
        verify(trackRespository,times(1)).save(track);
    }    }


