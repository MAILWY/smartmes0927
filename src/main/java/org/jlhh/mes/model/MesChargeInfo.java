package org.jlhh.mes.model;

/**
 * Created by wangyong on 2017/9/27.
 * 充放电机配电子看板信息表
 */
public class MesChargeInfo {
    private String rowId;
    private String testMach;
    private String channelNum;
    private String channelState;
    private String dateTime;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTestMach() {
        return testMach;
    }

    public void setTestMach(String testMach) {
        this.testMach = testMach;
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum;
    }

    public String getChannelState() {
        return channelState;
    }

    public void setChannelState(String channelState) {
        this.channelState = channelState;
    }
}
