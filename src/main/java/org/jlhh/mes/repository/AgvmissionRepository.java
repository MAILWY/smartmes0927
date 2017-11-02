package org.jlhh.mes.repository;

import org.jlhh.mes.model.AgvMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by wangyong on 2017/11/1.
 */
@Repository
public class AgvmissionRepository {
    //定义多数据源开始

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    //定义多数据源结束
    public AgvMission insert(AgvMission Agvmission) {
        String uuid = UUID.randomUUID().toString();
        String sql = "insert into agv_mission(tasktype,uuid,startpoint,endpoint) values(?,?,?,?)";
        this.jdbcTemplate.update(sql,
                1,
                uuid,
                "2",
                Agvmission.getEndPoint());
        return Agvmission;
    }

    public class ModuleGroupRowMapper implements RowMapper<AgvMission> {
        @Override
        public AgvMission mapRow(ResultSet rs, int rowNum) throws SQLException {
            AgvMission Agvmission = new AgvMission();
            Agvmission.setTaskType(rs.getString("tasktype"));
            Agvmission.setUuId(rs.getString("uuid"));
            Agvmission.setTasKid(rs.getString("taskid"));
            Agvmission.setTaskPriority(rs.getString("taskpriority"));
            Agvmission.setStartPoint(rs.getString("startpoint"));
            Agvmission.setEndPoint(rs.getString("endpoint"));
            Agvmission.setBeginTime(rs.getString("begintime"));
            Agvmission.setEndTime(rs.getString("endtime"));
            Agvmission.setTaskResult(rs.getString("taskresult"));
            Agvmission.setFailCode(rs.getString("failcode"));
            Agvmission.setFailMessage(rs.getString("failmessage"));
            Agvmission.setTaskSendTime(rs.getString("tasksendtime"));
            Agvmission.setTimeOut(rs.getString("timeout"));
            return Agvmission;
        }
    }
}
