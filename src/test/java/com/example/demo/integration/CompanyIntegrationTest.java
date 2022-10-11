package com.example.demo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired


    @Test
    public void test_post_shouldAddCompany_200() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("").contentType(MediaType.APPLICATION_JSON)).andReturn();

    }

}
