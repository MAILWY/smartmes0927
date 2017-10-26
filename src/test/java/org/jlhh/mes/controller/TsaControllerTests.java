package org.jlhh.mes.controller;

import org.jlhh.mes.service.TsaService;
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
public class TsaControllerTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private TsaService tsaService;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void selectAll() throws Exception {
        mockMvc.perform(get("/tsa/select"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectAll1() throws Exception {
        mockMvc.perform(post("/tsa/select"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    /////////////////////////////////////
    @Test
    public void updateGroupidByModuleid() throws Exception {
        mockMvc.perform(get("/tsa/update"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateGroupidByModuleid1() throws Exception {
        mockMvc.perform(post("/tsa/update")
                .param("tsaId", "1111")
                .param("tsaLine", "222")
                .param("tsaRow", "333")
                .param("tsaTime", "了；安居房；啦")
                .param("tsaUseflag", "了；安居房；啦"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
