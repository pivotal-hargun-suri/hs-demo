package com.example.hello.demo.Services;

import com.example.hello.demo.Entities.SomeOtherThingEntity;
import com.example.hello.demo.Repositories.SomeOtherThingReposiory;
import com.example.hello.demo.models.SomeOtherThing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class SomeOtherThingServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public SomeOtherThingService someOtherThingService() {
            return new SomeOtherThingServiceImpl();
        }
    }

    @Autowired
    private SomeOtherThingService someOtherThingService;

    @MockBean
    private SomeOtherThingReposiory someOtherThingReposiory;

    @Before
    public void setUp() {
        List<SomeOtherThingEntity> things = new ArrayList<>();
        SomeOtherThingEntity s1 = new SomeOtherThingEntity(0,"name1", "thing1");
        SomeOtherThingEntity s2 = new SomeOtherThingEntity(1,"name2", "thing2");

        things.add(s1);
        things.add(s2);

        given(someOtherThingReposiory.findAll()).willReturn(things);
        given(someOtherThingReposiory.findById(1)).willReturn(Optional.of(s1));
    }

    @Test
    public void getAllOtherThingsFromRepository() throws Exception {
        List<SomeOtherThing> result = someOtherThingService.getAllSomeOtherThing();

        assertThat(result.size()).isEqualTo(2);
        assertThat(((SomeOtherThing)result.get(0)).getName()).isEqualTo("name1");
        assertThat(((SomeOtherThing)result.get(1)).getName()).isEqualTo("name2");
    }

    @Test
    public void setSomeOtherThingToRepository() throws Exception {
        spy(someOtherThingReposiory);

        someOtherThingService.setSomeOtherThing();
        verify(someOtherThingReposiory, times(1)).save(any());
    }

    @Test
    public void getSomeOtherThingWithId() throws Exception {
        SomeOtherThing result = someOtherThingService.getSomeOtherThingById(1);

        assertThat(result.getName()).isEqualTo("name1");
        assertThat(result.getThing()).isEqualTo("thing1");
    }
}
