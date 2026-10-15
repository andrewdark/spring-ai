package ua.pp.darknsoft.mcpserverstdio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darknsoft.mcpserverstdio.entity.HelpDeskTicket;

import java.util.List;

public interface HelpDeskTicketRepository extends JpaRepository<HelpDeskTicket, Long> {
    List<HelpDeskTicket> findByUsername(String username);
}
