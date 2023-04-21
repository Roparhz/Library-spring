package fr.julienleveque.cefimtestcda2.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
// Penser à la mettre pour activer les validations par annotations
@Validated
public class ClientTests {
    @Autowired
    private ClientService clientService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllClientByAPI() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/client/all");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(requestBuilder)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
        List<Client> clients = Arrays.asList(objectMapper.readValue(contentAsString, Client[].class));
        List<Client> clients2 = objectMapper.readValue(contentAsString, new TypeReference<>() {});

        assert clients.contains(new Client("Julien", "Leveque", 1984,"test@test.fr"));
    }
}
