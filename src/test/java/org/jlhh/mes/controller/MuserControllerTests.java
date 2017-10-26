package org.jlhh.mes.controller;

import org.jlhh.mes.repository.UserReposiotry;
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
public class MuserControllerTests {
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private UserReposiotry userReposiotry;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void selectAll() throws Exception {
        mockMvc.perform(get("/user/select"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void selectAll1() throws Exception {
        mockMvc.perform(post("/user/select"))
                .andExpect(status().isOk())
                .andDo(print());
    }


///////////////////////////////////////////////////////////////

    @Test
    public void updateGroupidByModuleid() throws Exception {
        mockMvc.perform(get("/user/insert"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void updateGroupidByModuleid1() throws Exception {
        mockMvc.perform(post("/user/insert")
                .param("userId", "444")
                .param("userName", "马六"))
                .andExpect(status().isOk())
                .andDo(print());
    }
///////////////////////////////////////////////////////////////

    @Test
    public void DELETE() throws Exception {
        mockMvc.perform(get("/user/delete"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void DELETE1() throws Exception {
        mockMvc.perform(post("/user/delete")
                .param("userId", "333")
                .param("userName", "了；安居房；啦"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void UPDATE() throws Exception {
        mockMvc.perform(get("/user/updatePwd"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void UPDATE1() throws Exception {
        mockMvc.perform(post("/user/updatePwd")
                .param("userId", "333")
                .param("userPwd", "333333333"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void loginIn() throws Exception {
        mockMvc.perform(get("/user/login"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void loginIn1() throws Exception {
        mockMvc.perform(post("/user/login")
                .param("userId", "222")
                .param("userPwd", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
