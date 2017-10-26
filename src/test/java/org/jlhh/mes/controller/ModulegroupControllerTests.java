package org.jlhh.mes.controller;

import org.jlhh.mes.repository.ModulegroupRepository;
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
/**
 * Created by wangyong on 2017/9/29.
 */
public class ModulegroupControllerTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ModulegroupRepository modulegroupRepository;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void insertModulegroup() throws Exception {
        mockMvc.perform(get("/modulegroup/insert"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void insertModulegroup1() throws Exception {
        mockMvc.perform(post("/modulegroup/insert")
                .param("moduleId", "1213wqetry")
                .param("groupId", "123")
                .param("boxId", "111asda11")
                .param("bmsId", "11fdsaf111"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void updateGroupidByModuleid() throws Exception {
        mockMvc.perform(get("/modulegroup/updateGroupidByModuleid"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateGroupidByModuleid1() throws Exception {
        mockMvc.perform(post("/modulegroup/updateGroupidByModuleid")
                .param("moduleId", "1213wqetry")
                .param("groupId", "1231231313")
                .param("boxId", "111asda11")
                .param("bmsId", "11fdsaf111"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectbyid() throws Exception {
        mockMvc.perform(get("/modulegroup/selectbyid"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectbyid1() throws Exception {
        mockMvc.perform(post("/modulegroup/selectbyid")
                .param("moduleGroupId", "1001"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectByBoxid() throws Exception {
        mockMvc.perform(get("/modulegroup/selectByBoxid"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectByBoxid1() throws Exception {
        mockMvc.perform(post("/modulegroup/selectByBoxid")
                .param("BoxId", "23423423"))
                .andExpect(status().isOk())
                .andDo(print());
    }


}
