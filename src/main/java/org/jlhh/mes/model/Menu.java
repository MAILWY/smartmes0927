package org.jlhh.mes.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangjialin on 2017/9/17.
 */
public class Menu {

    private int id;
    private String menuName;
    private String menuResource;
    private String menuFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuResource() {
        return menuResource;
    }

    public void setMenuResource(String menuResource) {
        this.menuResource = menuResource;
    }

    public String getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(String menuFlag) {
        this.menuFlag = menuFlag;
    }

}
