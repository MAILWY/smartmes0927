package org.jlhh.mes.model;

/**
 * Created by wangjialin on 2017/9/17.
 * 负极焊接表
 */
public class Woald2 {
    private int woaldId;
    private String woaldDate;
    private String endDate;
    private String electricCurrent;
    private String electricVoltage;
    private String capacityFactor;

    public int getWoaldId() {
        return woaldId;
    }

    public void setWoaldId(int woaldId) {
        this.woaldId = woaldId;
    }

    public String getWoaldDate() {
        return woaldDate;
    }

    public void setWoaldDate(String woaldDate) {
        this.woaldDate = woaldDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getElectricCurrent() {
        return electricCurrent;
    }

    public void setElectricCurrent(String electricCurrent) {
        this.electricCurrent = electricCurrent;
    }

    public String getElectricVoltage() {
        return electricVoltage;
    }

    public void setElectricVoltage(String electricVoltage) {
        this.electricVoltage = electricVoltage;
    }

    public String getCapacityFactor() {
        return capacityFactor;
    }

    public void setCapacityFactor(String capacityFactor) {
        this.capacityFactor = capacityFactor;
    }
}
