package com.example.hello.demo.Repositories;

import com.example.hello.demo.Entities.SomeOtherThingEntity;
import com.example.hello.demo.models.SomeOtherThing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SomeOtherThingRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SomeOtherThingReposiory someOtherThingReposiory;

    @Test
    public void findOtherThingById() throws Exception {
        SomeOtherThingEntity s1 = new SomeOtherThingEntity();
        s1.setName("name1");
        s1.setThing("thing1");
        testEntityManager.persist(s1);
        testEntityManager.flush();

        SomeOtherThingEntity result = new SomeOtherThingEntity();
        someOtherThingReposiory.findByName("name1").ifPresent(val -> {
            result.setThing(val.getThing());
            result.setName(val.getName());
        });

        assertThat(result.getThing()).isEqualTo("thing1");
    }
}
