package com.voting.votingApp.services;

import com.voting.votingApp.model.OptionVote;
import com.voting.votingApp.model.Poll;
import com.voting.votingApp.repositories.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollServices {
    private final PollRepository pollRepository;

    public PollServices(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        // Get Poll from BD
        Poll poll = pollRepository.findById(pollId)
            .orElseThrow(() -> new RuntimeException("Poll not found"));

        // Get all Options
        List<OptionVote> options = poll.getOptions();

        // If index for vote is not valid, throw error
        if (optionIndex < 0 || optionIndex > options.size()) {
            throw new IllegalArgumentException("Invalid options index");
        }

        // Get Selected Option
        OptionVote selectedOption = options.get(optionIndex);

        // Increment vote for selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        // Save incremented option into the database
        pollRepository.save(poll);
    }
}
