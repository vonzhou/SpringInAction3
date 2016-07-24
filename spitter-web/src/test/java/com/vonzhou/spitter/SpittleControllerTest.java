package com.vonzhou.spitter;

import com.vonzhou.spitter.controller.SpittleController;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by vonzhou on 16/7/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-context.xml")
@WebAppConfiguration
public class SpittleControllerTest {




    @Mock
    SpittleController spittleController;




}
