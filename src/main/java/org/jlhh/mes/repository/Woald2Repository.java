package org.jlhh.mes.repository;

import org.jlhh.mes.model.Woald2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wangyong on 2017/9/27.
 */
@Repository
public class Woald2Repository {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    //定义多数据源开始
    SimpleDateFormat enddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置焊接参数实效日期
    private Logger logger = LoggerFactory.getLogger(getClass());
    //定义多数据源结束

    public Woald2 insert(Woald2 woald2) {
        String sql = "insert into woald2(woald_date,electric_current,electric_voltage,capacity_factor) values(?,?,?,?)";
        this.jdbcTemplate.update(sql,
                woald2.getWoaldDate(),
                woald2.getElectricCurrent(),
                woald2.getElectricVoltage(),
                woald2.getCapacityFactor());
        return woald2;
    }

    public int delete(String woaldDate) {
        String sql = "delete from woald2 where woald_date=?";
        return this.jdbcTemplate.update(sql, woaldDate);
    }

    public Woald2 update(Woald2 woald2) {
        String sql = "update  woald2 set end_date=? where end_date = null ";
        this.jdbcTemplate.update(sql, enddate);
        return woald2;
    }

    public List<Woald2> selectByDate(String date) {
        String sql = "select * from woald2 where date_format(woald_date, '%Y-%m-%d %H:%i:%s') <= date_format(?, '%Y-%m-%d %H:%i:%s') " +
                " and date_format(?, '%Y-%m-%d %H:%i:%s') <= date_format(end_date, '%Y-%m-%d %H:%i:%s')";
        List<Woald2> woald1List = this.jdbcTemplate.query(sql, new Woald2RowMapper(), date);
        return woald1List;
    }


    private class Woald2RowMapper implements RowMapper<Woald2> {
        @Override
        public Woald2 mapRow(ResultSet rs, int rowNum) throws SQLException {
            Woald2 woald2 = new Woald2();
            woald2.setWoaldId(rs.getInt("woald_id"));
            woald2.setWoaldDate(rs.getString("woald_date"));
            woald2.setEndDate(rs.getString("end_date"));
            woald2.setElectricCurrent(rs.getString("electric_current"));
            woald2.setElectricVoltage(rs.getString("electric_voltage"));
            woald2.setCapacityFactor(rs.getString("capacity_factor"));
            return woald2;
        }
    }
}
