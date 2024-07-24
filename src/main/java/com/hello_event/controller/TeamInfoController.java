package com.hello_event.controller;

import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.model.Event;
import com.hello_event.model.TeamInfo;
import com.hello_event.service.TeamInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/teamInfo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TeamInfoController {
    @Autowired
    private final TeamInfoService teamInfoService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            List<TeamInfo> teamsInfo = teamInfoService.getTeamsInfo();
            return ResponseEntity.ok(teamsInfo);
        } catch (DatabaseEmptyException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}