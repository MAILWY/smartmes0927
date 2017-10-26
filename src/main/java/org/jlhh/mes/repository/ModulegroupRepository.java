package org.jlhh.mes.repository;

import org.jlhh.mes.model.ModuleGroup;
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
public class ModulegroupRepository {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;
    //定义多数据源开始
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    private Logger logger = LoggerFactory.getLogger(getClass());
    //定义多数据源结束

    public ModuleGroup insertmodulegroup(ModuleGroup Modulegroup) {
        String sql = "insert into module_group(box_id,bms_id,group_id,module_id1,module_id2,module_id3,module_id4,module_id5,module_id6,module_id7,module_id8,module_id9,module_id10,module_id11,module_id12) " +
                " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        this.jdbcTemplate.update(sql,
                Modulegroup.getBoxId(),
                Modulegroup.getBmsId(),
                Modulegroup.getGroupId(),
                Modulegroup.getModuleId1(),
                Modulegroup.getModuleId2(),
                Modulegroup.getModuleId3(),
                Modulegroup.getModuleId4(),
                Modulegroup.getModuleId5(),
                Modulegroup.getModuleId6(),
                Modulegroup.getModuleId7(),
                Modulegroup.getModuleId8(),
                Modulegroup.getModuleId9(),
                Modulegroup.getModuleId10(),
                Modulegroup.getModuleId11(),
                Modulegroup.getModuleId12()
        );
        return Modulegroup;
    }

    /*
        public ModuleGroup updateGroupidByModuleid(ModuleGroup Modulegroup) {
            String sql = "UPDATE module_group a, module_group b SET a.group_id=? WHERE a.group_id=b.group_id AND b.module_id=? ";
            this.jdbcTemplate.update(sql,
                    Modulegroup.getGroupId(),
                    Modulegroup.getModuleId());
            return Modulegroup;
        }
    */
    public ModuleGroup updateBoxidByModuleid(String BoxId, String Modulegroup) {
        String sql = "UPDATE module_group SET box_id=? WHERE group_id =? ";
        this.jdbcTemplate.update(sql,
                BoxId,
                Modulegroup);
        return null;
    }

    public ModuleGroup selectByModuleid(String Modulegroup) {
        String sql = "select * from module_group WHERE " +
                " module_id1 =? OR " +
                " module_id2 =? OR " +
                " module_id3 =? OR " +
                " module_id4 =? OR " +
                " module_id5 =? OR " +
                " module_id6 =? OR " +
                " module_id7 =? OR " +
                " module_id8 =? OR " +
                " module_id9 =? OR " +
                " module_id10=? OR " +
                " module_id11=? OR " +
                " module_id12=? ";
        ModuleGroup ModuleGroup = this.jdbcTemplate.queryForObject(sql, new ModuleGroupRowMapper(),
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup,
                Modulegroup);
        return ModuleGroup;
    }


    public ModuleGroup updateBmsidByModuleid(String BmsId, String Modulegroup) {

        String sql = "UPDATE module_group SET bms_id=? WHERE group_id  =? ";
        this.jdbcTemplate.update(sql,
                BmsId,
                Modulegroup);
        return null;
    }

    public List<ModuleGroup> selectByBoxid(String BoxId) {
        String sql = "select * from module_group where box_id = ? ";
        List<ModuleGroup> moduleGroupList = this.jdbcTemplate.query(sql, new ModuleGroupRowMapper(), BoxId.trim());
        return moduleGroupList;
    }

    public List<ModuleGroup> selectByBoxidBmsid(String BoxId, String BmsId) {
        String sql = "select * from module_group where box_id=? AND bms_id = ? ";
        List<ModuleGroup> moduleGroupList = this.jdbcTemplate.query(sql, new ModuleGroupRowMapper(), BoxId, BmsId);
        return moduleGroupList;
    }

    public class ModuleGroupRowMapper implements RowMapper<ModuleGroup> {
        @Override
        public ModuleGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
            ModuleGroup Modulegroup = new ModuleGroup();
            Modulegroup.setBoxId(rs.getString("box_id"));
            Modulegroup.setBmsId(rs.getString("bms_id"));
            Modulegroup.setGroupId(rs.getString("group_id"));
            Modulegroup.setModuleId1(rs.getString("module_id1"));
            Modulegroup.setModuleId2(rs.getString("module_id2"));
            Modulegroup.setModuleId3(rs.getString("module_id3"));
            Modulegroup.setModuleId4(rs.getString("module_id4"));
            Modulegroup.setModuleId5(rs.getString("module_id5"));
            Modulegroup.setModuleId6(rs.getString("module_id6"));
            Modulegroup.setModuleId7(rs.getString("module_id7"));
            Modulegroup.setModuleId8(rs.getString("module_id8"));
            Modulegroup.setModuleId9(rs.getString("module_id9"));
            Modulegroup.setModuleId10(rs.getString("module_id10"));
            Modulegroup.setModuleId11(rs.getString("module_id11"));
            Modulegroup.setModuleId12(rs.getString("module_id12"));
            return Modulegroup;
        }
    }

}
