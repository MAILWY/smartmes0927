package org.jlhh.mes.repository;

import org.jlhh.mes.model.MesProdTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by wangyong on 2017/9/27.
 */
@Repository
public class MesprodtestRepository {
    //定义多数据源开始

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    //定义多数据源结束


    public MesProdTest selectByProdnum(String prodNum) {
        String sql = "select * from mes_prod_test WHERE prod_num=?";
        MesProdTest Mesprodtest = this.jdbcTemplate.queryForObject(sql, new MesprodtestRowMapper(), prodNum);
        return Mesprodtest;
    }

    public class MesprodtestRowMapper implements RowMapper<MesProdTest> {
        @Override
        public MesProdTest mapRow(ResultSet rs, int rowNum) throws SQLException {
            MesProdTest Mesprodtest = new MesProdTest();
            Mesprodtest.setTestDate(rs.getString("test_date"));
            Mesprodtest.setWorkOrder(rs.getString("work_order"));
            Mesprodtest.setProdNum(rs.getString("prod_num"));
            Mesprodtest.setTestMach(rs.getString("test_mach"));
            Mesprodtest.setAdjId(rs.getString("adj_id"));
            Mesprodtest.setApproId(rs.getString("appro_id"));
            Mesprodtest.setChargeHeight(rs.getString("charge_height"));
            Mesprodtest.setChargeLow(rs.getString("charge_low"));
            Mesprodtest.setChargeDiff(rs.getString("charge_diff"));
            Mesprodtest.setChargeResult(rs.getString("charge_result"));
            Mesprodtest.setDischargeHeight(rs.getString("discharge_height"));
            Mesprodtest.setDischargeLow(rs.getString("discharge_low"));
            Mesprodtest.setDischargeDiff(rs.getString("discharge_diff"));
            Mesprodtest.setDischargeResult(rs.getString("discharge_result"));
            Mesprodtest.setDischargeDiff_3(rs.getString("discharge_diff_3"));
            Mesprodtest.setDischargeDiffResult(rs.getString("discharge_diff_result"));
            Mesprodtest.setDischargeTempdiff(rs.getString("discharge_tempdiff"));
            Mesprodtest.setDischargeTempResult(rs.getString("discharge_temp_result"));
            Mesprodtest.setChargeHalfVolt(rs.getString("charge_half_volt"));
            Mesprodtest.setChargeHalfResult(rs.getString("charge_half_result"));
            Mesprodtest.setChargeHalfSoc(rs.getString("charge_half_soc"));
            Mesprodtest.setChargeHalfSoc_r(rs.getString("charge_half_soc_r"));
            Mesprodtest.setLastJudgement(rs.getString("last_judgement"));
            return Mesprodtest;
        }
    }

}
