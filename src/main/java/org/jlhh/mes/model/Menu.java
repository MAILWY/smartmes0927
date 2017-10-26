package org.jlhh.mes.model;

/**
 * Created by wangjialin on 2017/9/17.
 * 菜单表
 */
public class Menu {

    private String menuid;
    private String menuName;
    private String menuResource;
    private String menuFlag;
    private String dateTime;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
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
