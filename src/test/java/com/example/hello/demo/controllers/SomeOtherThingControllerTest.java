package com.example.hello.demo.controllers;

import com.example.hello.demo.Services.SomeOtherThingService;
import com.example.hello.demo.models.SomeOtherThing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SomeOtherThingController.class)
public class SomeOtherThingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SomeOtherThingService someOtherThingService;

    @Test
    public void getAllThings() throws Exception {
        List<SomeOtherThing> things = new ArrayList<>();
        SomeOtherThing s1 = new SomeOtherThing("name1", "thing1");
        SomeOtherThing s2 = new SomeOtherThing("name2", "thing2");

        things.add(s1);
        things.add(s2);

        given(someOtherThingService.getAllSomeOtherThing()).willReturn(things);

        mockMvc.perform(get("/sot")).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void setAThing() throws Exception {
        spy(someOtherThingService);

        mockMvc.perform(post("/sot")).andExpect(status().isOk());
        verify(someOtherThingService, times(1)).setSomeOtherThing();
    }

    @Test
    public void getAllThingById() throws Exception {
        SomeOtherThing s1 = new SomeOtherThing("name2", "thing2");
        given(someOtherThingService.getSomeOtherThingById(1)).willReturn(s1);

        mockMvc.perform(get("/sot/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("name2"));
    }
}
