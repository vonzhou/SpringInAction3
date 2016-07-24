package com.vonzhou.spitter;

import com.vonzhou.spitter.controller.SpitterController;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.ServletContext;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * Created by vonzhou on 16/7/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-context.xml")
@WebAppConfiguration
public class SpitterControllerTest {

    private static Logger logger = Logger.getLogger(SpitterControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    SpitterController spitterController;

    @Autowired
    ServletContext servletContext;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(spitterController).build();
    }

    @Test
    public void testGetSpitterInJson() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/json/test")).andDo(print());
    }

    @Test
    public void testGetAllSpitters() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/all")).andDo(print());
    }

    @Test
    public void testShowSpitterProfile() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/chown2")).andDo(print());
    }

    @Test
    public void testCreateSpitterProfile() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter").param("new", "value")).andDo(print());
    }

    @Test
    public void testUploadImage() throws Exception{
        File file = new File("/Users/vonzhou/Downloads/1.jpeg");
        FileInputStream fileInputStream = new FileInputStream(file);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("avatar", file.getName(), "multipart/form-data", fileInputStream);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/spitter/upload").file(mockMultipartFile).param("name", "vonzhou").param("desc", "a student")).andDo(print());

    }
}
