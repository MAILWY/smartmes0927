package org.jlhh.mes.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by wangyong on 2017/9/27.
 */
@Repository
public class BatterycellRepository extends Batterycell0Repository {
    @Override
    public String getTableName() {
        return "batterycell";
    }
}
