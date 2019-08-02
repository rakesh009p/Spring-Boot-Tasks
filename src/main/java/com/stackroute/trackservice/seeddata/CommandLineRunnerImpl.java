package com.stackroute.trackservice.seeddata;


import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private TrackRespository trackRepository;
    @Autowired
    public CommandLineRunnerImpl(TrackRespository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track1=new Track(1,"rakesh","nice");
        trackRepository.save(track1);
        Track track2=new Track(3,"purimetla","nice");
        trackRepository.save(track2);
    }
}