package com.hello_event.service;

import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.model.TeamInfo;
import com.hello_event.repository.TeamInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamInfoService {
    @Autowired
    private final TeamInfoRepository teamInfoRepository;

    public List<TeamInfo> getTeamsInfo() {
        List<TeamInfo> teamsInfo = teamInfoRepository.findAll();
        if (teamsInfo.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return teamsInfo;
    }
}
