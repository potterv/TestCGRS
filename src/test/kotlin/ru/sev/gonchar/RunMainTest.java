package ru.sev.gonchar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class RunMainTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void main() {
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testHelloWorldEndpoint() throws Exception {
        String response = mvc
                .perform(get("/api/res"))
                .andReturn().getResponse().getContentAsString();
        assertEquals("[0,1,2,3,4,5,6,7,8,9,10]", response);
    }

    @Test
    public void testApiLength() throws Exception {
        String response = mvc
                .perform(get("/api/res/length/3"))
                .andReturn().getResponse().getContentAsString();
        assertEquals("3", response);
    }

}