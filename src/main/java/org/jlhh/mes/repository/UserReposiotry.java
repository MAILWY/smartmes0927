package org.jlhh.mes.repository;

import org.jlhh.mes.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangjialin on 2017/9/17.
 */
@Repository
public class UserReposiotry {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> selectAll() {
        String sql = "select * from user";
        List<User> userList = this.jdbcTemplate.query(sql, new UserRowMapper());
        return userList;
    }

    ;

    public User insert(User user) {
        String sql = "insert into user(user_id,user_pwd,user_name,user_sex,user_birthday) values(?,?,?,?,?)";
        this.jdbcTemplate.update(sql,
                user.getUserId(),
                user.getUserPwd(),
                user.getUserName(),
                user.getUserSex(),
                user.getUserBirthday());
        return user;
    }

    public User update(User user) {
        String sql = "update user set user_name=?,user_sex=?,user_birthday=? where user_id=?";
        this.jdbcTemplate.update(sql,
                user.getUserName(),
                user.getUserSex(),
                user.getUserBirthday(),
                user.getUserId());
        return user;
    }

    public int updatePwd(User user) {
        String sql = "update user set user_pwd=? where user_id=?";
        int count = this.jdbcTemplate.update(sql,
                user.getUserPwd(),
                user.getUserId());
        return count;
    }

    public int delete(String userId) {
        String sql = "delete from user where user_id=?";
        return this.jdbcTemplate.update(sql, userId);
    }

    public int empty() throws Exception {
        if (true) {
            throw new Exception("不允许此操作");
        }
        String sql = "delete from user";
        return this.jdbcTemplate.update(sql);
    }


    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getString("user_id"));
            user.setUserPwd(rs.getString("user_pwd"));
            user.setUserName(rs.getString("user_name"));
            user.setUserSex(rs.getString("user_sex"));
            user.setUserBirthday(rs.getString("user_birthday"));
            return user;
        }
    }
}
