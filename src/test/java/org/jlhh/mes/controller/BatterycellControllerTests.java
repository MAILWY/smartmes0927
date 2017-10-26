package org.jlhh.mes.controller;

import org.jlhh.mes.repository.BatterycellRepository;
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

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Created by wangyong on 2017/9/29.
 */
public class BatterycellControllerTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private BatterycellRepository batterycellRepository;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void updateBatterycellTest() throws Exception {
        mockMvc.perform(get("/batterycell/update"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    //要写Batterycell的get set  方法中的变量名，不写数据库字段的
    @Test
    public void updateBatterycellTest1() throws Exception {
        System.out.println("------------");
        mockMvc.perform(post("/batterycell/update")
                .param("cellId", "")
                .param("pedestalId", "afj1111111")
                .param("cmoduleId", "12125555555555121"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateBatterycellTest_mes() throws Exception {
        mockMvc.perform(get("/batterycell/update_sl_mes"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    //要写Batterycell的get set  方法中的变量名，不写数据库字段的
    @Test
    public void updateBatterycellTest1_mes() throws Exception {
        System.out.println("------------");
        mockMvc.perform(post("/batterycell/update_sl_mes")
                .param("cellId", "")
                .param("pedestalId", "11")
                .param("cmoduleId", "3333332223"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updatecellTest() throws Exception {
        mockMvc.perform(get("/batterycell/updateCellid"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    //要写Batterycell的get set  方法中的变量名，不写数据库字段的
    @Test
    public void updatecellTest1() throws Exception {
        mockMvc.perform(post("/batterycell/updateCellid")
                .param("OldCellid", "45")
                .param("NewCellid", "111"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
