package org.jlhh.mes.repository;

import org.jlhh.mes.model.Batterycell;
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

//import javax.activation.DataSource;

/**
 * Created by wangyong on 2017/9/27.
 */
@Repository
public abstract class Batterycell0Repository {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    //定义多数据源开始
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;
    private Logger logger = LoggerFactory.getLogger(getClass());
    //定义多数据源结束

    public abstract String getTableName();

    /*暂时不需要INSERT，由分选机存入我们的数据库
        public Batterycell insert(Batterycell batterycell) {
            String sql = "insert into "+getTableName()+"(cell_id,pedestal_id,module_id) values(?,?,?)";
            this.jdbcTemplate.update(sql,
                    batterycell.getCellId(),
                    batterycell.getPedestalId(),
                    batterycell.getCmoduleId());
            return batterycell;

        }
    */
    public Batterycell update(Batterycell batterycell) {
        String sql = "update " + getTableName() + " set module_id=? where pedestal_id= ? ";
        this.jdbcTemplate.update(sql,
                batterycell.getCmoduleId().trim(),
                batterycell.getPedestalId().trim());
        return batterycell;
    }

    public Batterycell update_sl_mes(Batterycell batterycell) {
        String sql = "update " + getTableName() + " set module_id=? where pedestal_id= ? ";
        this.jdbcTemplate2.update(sql,
                batterycell.getCmoduleId().trim(),
                batterycell.getPedestalId().trim());
        return batterycell;
    }


    //循环45次，动态的更新匹配上的列值。
    public Batterycell updateCellid(String OldCellid, String NewCellid) {
        for (int i = 1; i <= 45; i++) {
            String sql = "update batterycell set cell_id" + i + "=? where cell_id" + i + "=?   ";
            this.jdbcTemplate.update(sql,
                    NewCellid,
                    OldCellid);
        }
        return null;
    }

    public List<Batterycell> selectAll() {
        String sql = "select * from " + getTableName();
        List<Batterycell> batterycellList = this.jdbcTemplate.query(sql, new BatterycellRowMapper());
        return batterycellList;
    }

    public Batterycell selectByCellid(String cellId) {
        String sql = "select * from " + getTableName() + " WHERE" +
                " cell_id2 =? OR " +
                " cell_id3 =? OR " +
                " cell_id4 =? OR " +
                " cell_id5 =? OR " +
                " cell_id6 =? OR " +
                " cell_id7 =? OR " +
                " cell_id8 =? OR " +
                " cell_id9 =? OR " +
                " cell_id10=? OR " +
                " cell_id11=? OR " +
                " cell_id12=? OR " +
                " cell_id13=? OR " +
                " cell_id14=? OR " +
                " cell_id15=? OR " +
                " cell_id16=? OR " +
                " cell_id17=? OR " +
                " cell_id18=? OR " +
                " cell_id19=? OR " +
                " cell_id20=? OR " +
                " cell_id21=? OR " +
                " cell_id22=? OR " +
                " cell_id23=? OR " +
                " cell_id24=? OR " +
                " cell_id25=? OR " +
                " cell_id26=? OR " +
                " cell_id27=? OR " +
                " cell_id28=? OR " +
                " cell_id29=? OR " +
                " cell_id30=? OR " +
                " cell_id31=? OR " +
                " cell_id32=? OR " +
                " cell_id33=? OR " +
                " cell_id34=? OR " +
                " cell_id35=? OR " +
                " cell_id36=? OR " +
                " cell_id37=? OR " +
                " cell_id38=? OR " +
                " cell_id39=? OR " +
                " cell_id40=? OR " +
                " cell_id41=? OR " +
                " cell_id42=? OR " +
                " cell_id43=? OR " +
                " cell_id44=? OR " +
                " cell_id45=?    ";
        Batterycell batterycell = this.jdbcTemplate.queryForObject(sql, new BatterycellRowMapper()
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
                , cellId
        );
        return batterycell;
    }

    public List<Batterycell> selectByCmoduleId(String cmoduleId) {
        String sql = "select * from " + getTableName() + " where cmodule_id = ?";
        List<Batterycell> batterycellList = this.jdbcTemplate.query(sql, new BatterycellRowMapper(), cmoduleId);
        return batterycellList;
    }

    public List<Batterycell> selectByPedestalId(String pedestalId) {
        String sql = "select * from " + getTableName() + " where pedestal_id = ?";
        List<Batterycell> batterycellList = this.jdbcTemplate.query(sql, new BatterycellRowMapper(), pedestalId);
        return batterycellList;
    }

    public class BatterycellRowMapper implements RowMapper<Batterycell> {
        @Override
        public Batterycell mapRow(ResultSet rs, int rowNum) throws SQLException {
            Batterycell batterycell = new Batterycell();
            batterycell.setPedestalId(rs.getString("pedestal_id"));
            batterycell.setCmoduleId(rs.getString("cmodule_id"));
            batterycell.setCellId1(rs.getString("cell_id1"));
            batterycell.setCellId2(rs.getString("cell_id2"));
            batterycell.setCellId3(rs.getString("cell_id3"));
            batterycell.setCellId4(rs.getString("cell_id4"));
            batterycell.setCellId5(rs.getString("cell_id5"));
            batterycell.setCellId6(rs.getString("cell_id6"));
            batterycell.setCellId7(rs.getString("cell_id7"));
            batterycell.setCellId8(rs.getString("cell_id8"));
            batterycell.setCellId9(rs.getString("cell_id9"));
            batterycell.setCellId10(rs.getString("cell_id10"));
            batterycell.setCellId11(rs.getString("cell_id11"));
            batterycell.setCellId12(rs.getString("cell_id12"));
            batterycell.setCellId13(rs.getString("cell_id13"));
            batterycell.setCellId14(rs.getString("cell_id14"));
            batterycell.setCellId15(rs.getString("cell_id15"));
            batterycell.setCellId16(rs.getString("cell_id16"));
            batterycell.setCellId17(rs.getString("cell_id17"));
            batterycell.setCellId18(rs.getString("cell_id18"));
            batterycell.setCellId19(rs.getString("cell_id19"));
            batterycell.setCellId20(rs.getString("cell_id20"));
            batterycell.setCellId21(rs.getString("cell_id21"));
            batterycell.setCellId22(rs.getString("cell_id22"));
            batterycell.setCellId23(rs.getString("cell_id23"));
            batterycell.setCellId24(rs.getString("cell_id24"));
            batterycell.setCellId25(rs.getString("cell_id25"));
            batterycell.setCellId26(rs.getString("cell_id26"));
            batterycell.setCellId27(rs.getString("cell_id27"));
            batterycell.setCellId28(rs.getString("cell_id28"));
            batterycell.setCellId29(rs.getString("cell_id29"));
            batterycell.setCellId30(rs.getString("cell_id30"));
            batterycell.setCellId31(rs.getString("cell_id31"));
            batterycell.setCellId32(rs.getString("cell_id32"));
            batterycell.setCellId33(rs.getString("cell_id33"));
            batterycell.setCellId34(rs.getString("cell_id34"));
            batterycell.setCellId35(rs.getString("cell_id35"));
            batterycell.setCellId36(rs.getString("cell_id36"));
            batterycell.setCellId37(rs.getString("cell_id37"));
            batterycell.setCellId38(rs.getString("cell_id38"));
            batterycell.setCellId39(rs.getString("cell_id39"));
            batterycell.setCellId40(rs.getString("cell_id40"));
            batterycell.setCellId41(rs.getString("cell_id41"));
            batterycell.setCellId42(rs.getString("cell_id42"));
            batterycell.setCellId43(rs.getString("cell_id43"));
            batterycell.setCellId44(rs.getString("cell_id44"));
            batterycell.setCellId45(rs.getString("cell_id45"));
            return batterycell;
        }
    }

}
