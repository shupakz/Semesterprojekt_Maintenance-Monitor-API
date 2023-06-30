package at.technkium.Maintenance.Monitor.API.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private String currentMessage = "Everything operates as expected";

    public String getCurrentMessage() {
        return currentMessage;
    }
}
