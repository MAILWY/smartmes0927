package org.jlhh.mes.repository;

import org.jlhh.mes.model.Menu;
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
public class MenuRepository {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    //定义多数据源开始
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    private Logger logger = LoggerFactory.getLogger(getClass());
    //定义多数据源结束

    public List<Menu> selectAll() {
        String sql = "select menu_id,menu_name,menu_resource from menu ";
        List<Menu> menuList = this.jdbcTemplate.query(sql, new MenuRowMapper());
        return menuList;
    }

    ;

    public Menu insert(Menu menu) {
        String sql = "insert into menu(menu_id,menu_name,menu_resource,menu_flag) values(?,?,?,?)";
        this.jdbcTemplate.update(sql,
                menu.getMenuid(),
                menu.getMenuName(),
                menu.getMenuResource(),
                menu.getMenuFlag());
        return menu;
    }

    /*暂时不需要更新，用户直接删掉重建。
        public Menu update(Menu menu) {
            String sql = "update user set menu_name=?,menu_resource=?,menu_flag=? where menu_id=?";
            this.jdbcTemplate.update(sql,
                    menu.getMenuName(),
                    menu.getMenuResource(),
                    menu.getMenuFlag(),
                    menu.getMenuid());
            return menu;
        }
    */
    public int delete(String id) {
        String sql = "delete from menu where menu_id=?";
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
            menu.setMenuid(rs.getString("menu_id"));
            menu.setMenuName(rs.getString("menu_name"));
            menu.setMenuResource(rs.getString("menu_resource"));
            return menu;
        }
    }
}
