package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

public class CustomerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CustomerController controller;

    @Mock
    private CustomerService service;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllCustomers() throws Exception{
        try{
            mockMvc.perform(MockMvcRequestBuilders.get("/customers")).andExpect(MockMvcResultMatchers.status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
        Mockito.verify(service).getAllCustomers();
    }

    @Test
    public void getCustomers() throws Exception{
        List<Customer> customerList = Arrays.asList(

                new Customer("Juan", 21, "address one", "male", "August",  233L),
                new Customer("John", 21, "address two", "male", "August",  244L)
        );

        Mockito.when(service.getCustomer(1L)).thenReturn(customerList.get(0));
        mockMvc.perform()
    }




}
