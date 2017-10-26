package org.jlhh.mes.controller;

import org.jlhh.mes.repository.UserMenuRepository;
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
public class MuserMenuControllerTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserMenuRepository userMenuRepository;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void selectAll() throws Exception {
        mockMvc.perform(get("/usermenu/select"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectAll1() throws Exception {
        mockMvc.perform(post("/usermenu/select")
                .param("userId", "111"))
                .andExpect(status().isOk())
                .andDo(print());
    }
////////////////////////////////////////////


    @Test
    public void deleteUserMenu() throws Exception {
        mockMvc.perform(get("/usermenu/delete"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void deleteUserMenu1() throws Exception {
        mockMvc.perform(post("/usermenu/delete")
                .param("userId", "33434"))
                .andExpect(status().isOk())
                .andDo(print());
    }
////////////////////////////////////////////


    @Test
    public void insertUserMenu() throws Exception {
        mockMvc.perform(get("/usermenu/insert"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void insertUserMenu1() throws Exception {
        mockMvc.perform(post("/usermenu/insert")
                .param("userId", "1111")
                .param("menuId", "1111"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
