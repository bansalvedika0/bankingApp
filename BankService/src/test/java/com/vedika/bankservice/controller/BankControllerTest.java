package com.vedika.bankservice.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vedika.bankservice.repository.BankAccountRepository;
import com.vedika.bankservice.service.BankAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BankController.class)
@WebAppConfiguration
public class BankControllerTest {
	 
	MockMvc mvc;
	   
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	BankController bankController;
	
	@Autowired
	BankAccountService bankAccountService;
	
	@Autowired
	BankAccountRepository bankAccountRepository;

	   
	protected void setUp() {
	   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getBalanceAPI() throws Exception 
	{
	  
		 MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
	  			.get("/balance")
	  			.requestAttr("accountNumber", "1")
	  			.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		Mockito.when(bankAccountService.getBalance(1)).thenReturn(12000.50);
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
	}
	
	@Configuration
	class TestConfog{
		
		@Bean
		public BankController bankController() {
		      return Mockito.mock(BankController.class);
		}
		
		@Bean
		public BankAccountRepository bankAccountRepository() {
		      return Mockito.mock(BankAccountRepository.class);
		}
		
		@Bean
		public BankAccountService bankAccountService() {
		      return Mockito.mock(BankAccountService.class);
		}
		
		
	}
}



