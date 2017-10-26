package org.jlhh.mes.service;

import org.jlhh.mes.repository.Woald2Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/9/27.
 */
@Service
public class Woald2Service {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Woald2Repository woald2Repository;

    public Woald2Repository getWoald2Repository() {
        return woald2Repository;
    }

    public void setWoald2Repository(Woald2Repository woald2Repository) {
        this.woald2Repository = woald2Repository;
    }
}
