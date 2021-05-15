package com.yuriy.SpringBackendApp;

import com.yuriy.SpringBackendApp.repos.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    private void setUp() {
        User john = new User("john.smith@example.com", "john", "smith");
        john.setId(1);
        User alex = new User("alex.smith@example.com", "alex", "smith");
        alex.setId(2);

        when(userRepository.findAll())
                .thenReturn(List.of(john, alex));
    }

    @Test
    public void printMain() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("This is the main page")));
    }

    @Test
    void greet() throws Exception {
        this.mockMvc.perform(get("/greet")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    @Test
    void getAllUsers() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").exists())
                .andExpect(jsonPath("$[0].email").value("john.smith@example.com"))
                .andExpect(jsonPath("$[0].firstName").exists())
                .andExpect(jsonPath("$[0].surName").exists())
                .andReturn();

        Assert.assertEquals("application/json",
                mvcResult.getResponse().getContentType());
    }

}