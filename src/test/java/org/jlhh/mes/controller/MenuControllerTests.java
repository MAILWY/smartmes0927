package org.jlhh.mes.controller;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by wangjialin on 2017/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuControllerTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void insertMenuTest() throws Exception {
        mockMvc.perform(get("/menu/insert"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void insertMenuTest1() throws Exception {
        mockMvc.perform(post("/menu/insert")
                .param("userId","abc")
                .param("userPwd","888888"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
