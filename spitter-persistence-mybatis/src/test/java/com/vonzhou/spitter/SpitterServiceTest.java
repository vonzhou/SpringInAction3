package com.vonzhou.spitter;

import com.vonzhou.spitter.domain.Spitter;
import com.vonzhou.spitter.service.SpitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by vonzhou on 16/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpitterServiceTest {

    @Autowired
    private SpitterService spitterService;

    @Test
    public void testFindAllSpitters() {
        List<Spitter> spitters = spitterService.findAllSpitters();
        assertNotNull(spitters);
        for (Spitter s : spitters) {
            assertNotNull(s);
            System.out.println(s);
        }
    }
}
