package ua.pp.darknsoft.openai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darknsoft.openai.entity.HelpDeskTicket;

import java.util.List;

public interface HelpDeskTicketRepository extends JpaRepository<HelpDeskTicket, Long> {
    List<HelpDeskTicket> findByUsername(String username);
}
