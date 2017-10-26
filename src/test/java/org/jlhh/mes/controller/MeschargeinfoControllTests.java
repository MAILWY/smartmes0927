package org.jlhh.mes.controller;

import org.jlhh.mes.repository.MeschargeinfoRepository;
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

public class MeschargeinfoControllTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private MeschargeinfoRepository meschargeinfoRepository;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void selectMeschargeinfo() throws Exception {
        mockMvc.perform(get("/meschargeinfo/select"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectMeschargeinfo1() throws Exception {
        mockMvc.perform(post("/meschargeinfo/select"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
