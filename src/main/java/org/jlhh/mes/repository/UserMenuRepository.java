package org.jlhh.mes.repository;

import org.jlhh.mes.model.UserMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class UserMenuRepository {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    //定义多数据源开始
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    private Logger logger = LoggerFactory.getLogger(getClass());
    //定义多数据源结束

    public List<UserMenu> selectUserByUserid(String userId) {
        String sql = "select a.user_id AS user_id,a.menu_id AS menu_id,b.menu_name AS menu_name,b.menu_resource AS menu_resource from user_menu a,menu b where a.user_id = ? and a.menu_id=b.menu_id ";
        List<UserMenu> usermenuList = this.jdbcTemplate.query(sql, new UserMenuRowMapper(), userId);
        return usermenuList;
    }

    public int deleteUserMenu(String userId, String menuId) {
        String sql = "delete from user_menu where user_id=? and menu_id=? ";
        return this.jdbcTemplate.update(sql, userId, menuId);
    }

    public UserMenu insert(UserMenu usermenu) {
        String sql = "insert into user_menu(user_id,menu_id) values(?,?)";
        this.jdbcTemplate.update(sql,
                usermenu.getUserId(),
                usermenu.getMenuId());
        return usermenu;
    }

    public class UserMenuRowMapper implements RowMapper<UserMenu> {
        @Override
        public UserMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserMenu usermenu = new UserMenu();
            usermenu.setUserId(rs.getString("user_id"));
            usermenu.setMenuId(rs.getString("menu_id"));
            usermenu.setMenuName(rs.getString("menu_name"));
            usermenu.setMenuResource(rs.getString("menu_resource"));
            return usermenu;
        }
    }
}
