package org.jlhh.mes.service;

import java.util.Map;

/**
 * Created by wangjialin on 2017/10/10.
 */
public interface IBusiness {
    public Map<String, Object> trade(Map<String, Object> msgMap);
}
