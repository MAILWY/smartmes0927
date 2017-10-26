package org.jlhh.mes.model;

/**
 * Created by wangjialin on 2017/9/17.
 */
public class Defective {

    private String defectiveDate;
    private Double defectiveRate;
    private Integer defectiveNum;

    public String getDefectiveDate() {
        return defectiveDate;
    }

    public void setDefectiveDate(String defectiveDate) {
        this.defectiveDate = defectiveDate;
    }

    public Double getDefectiveRate() {
        return defectiveRate;
    }

    public void setDefectiveRate(Double defectiveRate) {
        this.defectiveRate = defectiveRate;
    }

    public Integer getDefectiveNum() {
        return defectiveNum;
    }

    public void setDefectiveNum(Integer defectiveNum) {
        this.defectiveNum = defectiveNum;
    }
}
