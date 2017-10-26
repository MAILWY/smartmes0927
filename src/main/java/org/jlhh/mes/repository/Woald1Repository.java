package org.jlhh.mes.repository;

import org.jlhh.mes.model.Woald1;
import org.jlhh.mes.utils.Time;
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
 * Created by wangyong on 2017/9/27.
 */
@Repository
public class Woald1Repository {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    //定义多数据源开始
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    private Logger logger = LoggerFactory.getLogger(getClass());
    //定义多数据源结束
    private String enddate = Time.getStringDate();//设置焊接参数实效日期

    public Woald1 insert(Woald1 woald1) {
        String sql = "insert into woald1(woald_date,electric_current,electric_voltage,capacity_factor) values(?,?,?,?)";
        this.jdbcTemplate.update(sql,
                woald1.getWoaldDate(),
                woald1.getElectricCurrent(),
                woald1.getElectricVoltage(),
                woald1.getCapacityFactor());
        return woald1;
    }

    public int delete(String woaldDate) {
        String sql = "delete from woald1 where woald_id=?";
        return this.jdbcTemplate.update(sql, woaldDate);
    }

    public Woald1 update(Woald1 woald1) {
        String sql = "update  woald1 set end_date=? where woald_id = ? ";
        this.jdbcTemplate.update(sql, woald1.getEndDate(), woald1.getWoaldId());
        return woald1;
    }

    public List<Woald1> selectByDate(String date) {
        String sql = "select * from woald1 where date_format(woald_date, '%Y-%m-%d %H:%i:%s') <= date_format(?, '%Y-%m-%d %H:%i:%s') " +
                " and date_format(?, '%Y-%m-%d %H:%i:%s') <= date_format(end_date, '%Y-%m-%d %H:%i:%s')";
        List<Woald1> woald1List = this.jdbcTemplate.query(sql, new Woald1RowMapper(), date);
        return woald1List;
    }


    private class Woald1RowMapper implements RowMapper<Woald1> {
        @Override
        public Woald1 mapRow(ResultSet rs, int rowNum) throws SQLException {
            Woald1 woald1 = new Woald1();
            woald1.setWoaldId(rs.getInt("woald_id"));
            woald1.setWoaldDate(rs.getString("woald_date"));
            woald1.setEndDate(rs.getString("end_date"));
            woald1.setElectricCurrent(rs.getString("electric_current"));
            woald1.setElectricVoltage(rs.getString("electric_voltage"));
            woald1.setCapacityFactor(rs.getString("capacity_factor"));
            return woald1;
        }
    }
}
