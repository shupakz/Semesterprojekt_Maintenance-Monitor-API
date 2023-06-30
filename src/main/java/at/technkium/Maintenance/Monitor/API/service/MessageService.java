package at.technkium.Maintenance.Monitor.API.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getCurrentMessage() {
        String currentMessage = "Everything operates as expected";
        return currentMessage;
    }
}
