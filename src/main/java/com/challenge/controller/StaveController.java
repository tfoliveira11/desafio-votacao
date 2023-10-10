package com.challenge.controller;

import com.challenge.dto.StaveRequestDto;
import com.challenge.dto.StaveSessionRequestDto;
import com.challenge.dto.VoteCountResponseDto;
import com.challenge.model.Stave;
import com.challenge.model.StaveSession;
import com.challenge.service.StaveService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/stave")
@AllArgsConstructor
public class StaveController {

    private final StaveService staveService;

    @PostMapping
    public ResponseEntity<Stave> create(@RequestBody @Validated StaveRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(staveService.create(request));
    }

    @PostMapping("/{staveId}/session")
    public ResponseEntity<StaveSession> createSession(@PathVariable("staveId") Long staveId, @RequestBody @Validated StaveSessionRequestDto request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(staveService.session(staveId, request));
    }

    @PostMapping("/{staveId}/count-votes")
    public ResponseEntity<VoteCountResponseDto> countVotes(@PathVariable("staveId") Long staveId) {
        return ResponseEntity.status(HttpStatus.OK).body(staveService.countVotes(staveId));
    }
}
