package com.voting.votingApp.controllers;

import com.voting.votingApp.model.Poll;
import com.voting.votingApp.services.PollServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    private final PollServices pollServices;

    public PollController(PollServices pollServices) {
        this.pollServices = pollServices;
    }

    @GetMapping
    public List<Poll> getAllPolls() {
        return pollServices.getAllPolls();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id) {
        return pollServices.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Poll createPoll(@Valid @RequestBody Poll poll) {
        return pollServices.createPoll(poll);
    }
}

