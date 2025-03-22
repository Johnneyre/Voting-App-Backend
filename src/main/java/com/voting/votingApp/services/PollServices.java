package com.voting.votingApp.services;

import com.voting.votingApp.model.Poll;
import com.voting.votingApp.repositories.PollRepository;
import org.springframework.stereotype.Service;

@Service
public class PollServices {
    private final PollRepository pollRepository;

    public PollServices(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }
}
