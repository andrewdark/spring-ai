package ua.pp.darknsoft.openai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/tools")
public class TimeController {

    @GetMapping("/local-time")
    public ResponseEntity<String> localTime(@RequestHeader("username") String username, @RequestParam("message") String message) {
        return ResponseEntity.ok("Local time: " + new Date());
    }
}
