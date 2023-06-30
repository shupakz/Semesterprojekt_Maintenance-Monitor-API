package at.technkium.Maintenance.Monitor.API.controller;

import at.technkium.Maintenance.Monitor.API.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
