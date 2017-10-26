package org.jlhh.mes.controller;

import org.jlhh.mes.service.Woald1Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wangyong on 2017/9/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Woald1ControllerTests {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private Woald1Service woald1Service;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void selectAll() throws Exception {
        mockMvc.perform(get("/woald1/insert"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectAll1() throws Exception {
        mockMvc.perform(post("/woald1/insert")
                .param("woaldDate", "1111")
                .param("endDate", "1111")
                .param("electricCurrent", "1111")
                .param("electricVoltage", "1111")
                .param("capacityFactor", "1111")
        )
                .andExpect(status().isOk())
                .andDo(print());
    }

    /////////////////////////////////////
    @Test
    public void updateGroupidByModuleid() throws Exception {
        mockMvc.perform(get("/woald1/update"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateGroupidByModuleid1() throws Exception {
        mockMvc.perform(post("/woald1/update")
                .param("woaldId", "1")
                .param("woaldDate", "222")
                .param("endDate", "13251325123")
                .param("electricCurrent", "了；安居房；啦")
                .param("electricVoltage", "了；安居房；啦")
                .param("capacityFactor", "了；安居房；啦"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
