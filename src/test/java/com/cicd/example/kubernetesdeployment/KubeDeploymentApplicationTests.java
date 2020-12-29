package com.cicd.example.kubernetesdeployment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
class KubeDeploymentApplicationTests {
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void shouldSayHello_whenTheRequestIsSent() throws Exception {
		RequestBuilder requestBuilder = get("/v1/sayHello?name=Senthilkumar");
		mockMvc.perform(requestBuilder)
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().string("Hello Senthilkumar!!!"));
	}

}
