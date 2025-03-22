package com.voting.votingApp.controllers;

import com.voting.votingApp.model.Poll;
import com.voting.votingApp.services.PollServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    private final PollServices pollServices;

    public PollController(PollServices pollServices) {
        this.pollServices = pollServices;
    }

    @PostMapping
    public Poll createPoll(@Valid @RequestBody Poll poll) {
        return pollServices.createPoll(poll);
    }
}
