package at.technkium.Maintenance.Monitor.API.controller;

import at.technkium.Maintenance.Monitor.API.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<String> getMessage() {
        String currentMessage = messageService.getCurrentMessage();
        return ResponseEntity.ok(currentMessage);
    }

    @PostMapping("/set")
    public ResponseEntity<String> setMessage(@RequestParam("m") String message) {
        messageService.setMessage(message);
        return ResponseEntity.ok("ok");
    }
}
