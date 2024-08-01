package com.hello_event.service;

import com.hello_event.exception.DatabaseEmptyException;
import com.hello_event.model.Contact;
import com.hello_event.model.TeamInfo;
import com.hello_event.repository.TeamInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamInfoService {

    private final TeamInfoRepository teamInfoRepository;

    public List<TeamInfo> getTeamsInfo() {
        List<TeamInfo> teamsInfo = teamInfoRepository.findAll();
        if (teamsInfo.isEmpty()) {
            throw new DatabaseEmptyException();
        }
        return teamsInfo;
    }

    public TeamInfo save(TeamInfo teamInfo) {
        return teamInfoRepository.save(teamInfo);
    }
}
