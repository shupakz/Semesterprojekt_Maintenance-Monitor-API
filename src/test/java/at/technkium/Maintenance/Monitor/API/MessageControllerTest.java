package at.technkium.Maintenance.Monitor.API;

import at.technkium.Maintenance.Monitor.API.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class MessageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageService messageService;

    @BeforeEach
    public void setup() {
        // Reset the message to default before each test
        messageService.resetMessage();
    }

    @Test
    public void testGetMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/message"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Everything operates as expected"));
    }

    @Test
    public void testSetMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/message/set").param("m", "Service checks: No power until 5:00 pm"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("ok"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/message"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Service checks: No power until 5:00 pm"));
    }

    @Test
    public void testResetMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/message/set").param("m", "Service checks: No power until 5:00 pm"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("ok"));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/message/reset"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("ok"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/message"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Everything operates as expected"));
    }
}
