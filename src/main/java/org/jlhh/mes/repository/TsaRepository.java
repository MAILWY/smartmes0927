package org.jlhh.mes.repository;

import org.jlhh.mes.model.Tsa;
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
public class TsaRepository {
    //定义多数据源开始

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    //定义多数据源结束

    public List<Tsa> selectAll() {
        String sql = "select * from tsa order by tsa_id ";
        List<Tsa> tsaList = this.jdbcTemplate.query(sql, new TsaRowMapper());
        return tsaList;
    }

    public Tsa updateTsa(Tsa tsa) {
        String sql = "UPDATE  tsa  SET tsa_useflag=? WHERE tsa_id=? ";
        this.jdbcTemplate.update(sql,
                tsa.getTsaUseflag(),
                tsa.getTsaId());
        return tsa;
    }


    public class TsaRowMapper implements RowMapper<Tsa> {
        @Override
        public Tsa mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tsa tsa = new Tsa();
            tsa.setTsaId(rs.getString("tsa_id"));
            tsa.setTsaLine(rs.getString("tsa_line"));
            tsa.setTsaRow(rs.getString("tsa_row"));
            tsa.setTsaTime(rs.getString("tsa_time"));
            tsa.setTsaUseflag(rs.getString("tsa_useflag"));
            tsa.setTsaDesc(rs.getString("tsa_desc"));
            return tsa;
        }
    }
}
