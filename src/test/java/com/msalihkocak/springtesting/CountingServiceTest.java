package com.msalihkocak.springtesting;

import com.msalihkocak.springtesting.configuration.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class CountingServiceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CountingService countingService;

    @Test
    public void contextIsOk(){
        assertNotNull(dataSource);
        assertNotNull(countingService);
    }

    @Test
    public void whenNoItemsThenCountIsZero() {
        assertEquals(0, countingService.getCount());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void whenOneItemsThenCountISOne(){
        dataSource.add("one");
        assertEquals(1, countingService.getCount());
    }
}