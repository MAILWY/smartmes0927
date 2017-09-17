package org.jlhh.mes.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjialin on 2017/9/17.
 */
public class RetModel<T>{

    private String retCode;
    private String retMsg;
    private T retObj;
    private List<T> retList;
    public RetModel() {
        this.setRetCode("000");
        this.setRetMsg("操作成功!");
    }

    public RetModel(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getRetObj() {
        return retObj;
    }

    public void setRetObj(T retObj) {
        this.retObj = retObj;
    }

    public List<T> getRetList() {
        if (retList == null) {
            this.setRetList(new ArrayList<T>());
        }
        return retList;
    }

    public void setRetList(List<T> retList) {
        this.retList = retList;
    }
}
