package com.hello_event.repository;

import com.hello_event.model.TeamInfo;
import com.hello_event.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamInfoRepository extends JpaRepository<TeamInfo, Long> {

}
