package org.jlhh.mes.repository;

import org.jlhh.mes.model.MesChargeInfo;
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
 * 充放电看板信息表，充放电设备存入记录，只是查询，只需要检查数据是否24条。
 */
@Repository
public class MeschargeinfoRepository {
    //定义多数据源开始

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    //定义多数据源结束

    public List<MesChargeInfo> selectAll() {
        String sql = "select * from mes_charge_info order by row_id ";
        List<MesChargeInfo> meschargeinfoList = this.jdbcTemplate.query(sql, new MeschargeinfoRowMapper());
        return meschargeinfoList;
    }

    public class MeschargeinfoRowMapper implements RowMapper<MesChargeInfo> {
        @Override
        public MesChargeInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            MesChargeInfo Meschargeinfo = new MesChargeInfo();
            Meschargeinfo.setRowId(rs.getString("row_id"));
            Meschargeinfo.setTestMach(rs.getString("test_mach"));
            Meschargeinfo.setChannelNum(rs.getString("channel_num"));
            Meschargeinfo.setChannelState(rs.getString("channel_state"));

            return Meschargeinfo;
        }
    }
}
