package org.jlhh.mes.repository;

import org.jlhh.mes.model.Menu;
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
public class MenuRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Menu> selectAll() {
        String sql = "select * from user";
        List<Menu> menuList = this.jdbcTemplate.query(sql, new MenuRowMapper());
        return menuList;
    }

    ;

    public Menu insert(Menu menu) {
        String sql = "insert into menu(id,menu_name,menu_resource,menu_flag) values(?,?,?,?)";
        this.jdbcTemplate.update(sql,
                menu.getId(),
                menu.getMenuName(),
                menu.getMenuResource(),
                menu.getMenuFlag());
        return menu;
    }

    public Menu update(Menu user) {
        String sql = "update user set menu_name=?,menu_resource=?,menu_flag=? where id=?";
        this.jdbcTemplate.update(sql,
                user.getMenuName(),
                user.getMenuResource(),
                user.getMenuFlag(),
                user.getId());
        return user;
    }

    public int delete(int id) {
        String sql = "delete from menu where id=?";
        return this.jdbcTemplate.update(sql, id);
    }

    public int empty() throws Exception {
        if (true) {
            throw new Exception("不允许此操作");
        }
        String sql = "delete from menu";
        return this.jdbcTemplate.update(sql);
    }


    public class MenuRowMapper implements RowMapper<Menu> {
        @Override
        public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
            Menu menu = new Menu();
            menu.setId(rs.getInt("id"));
            menu.setMenuName(rs.getString("menu_name"));
            menu.setMenuResource(rs.getString("menu_resource"));
            menu.setMenuFlag(rs.getString("menu_flag"));
            return menu;
        }
    }
}
