package org.jlhh.mes.model;

/**
 * Created by wangjialin on 2017/9/17.
 * 用户角色
 */
public class UserMenu {
    private String userId;
    private String menuId;
    private String menuName;
    private String menuResource;
    private String operId;
    private String operTime;


    public String getMenuResource() {
        return menuResource;
    }

    public void setMenuResource(String menuResource) {
        this.menuResource = menuResource;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
