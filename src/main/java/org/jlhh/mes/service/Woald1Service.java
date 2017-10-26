package org.jlhh.mes.service;

import org.jlhh.mes.repository.Woald1Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/9/27.
 */
@Service
public class Woald1Service {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Woald1Repository woald1Repository;

    public Woald1Repository getWoald1Repository() {
        return woald1Repository;
    }

    public void setWoald1Repository(Woald1Repository woald1Repository) {
        this.woald1Repository = woald1Repository;
    }
}
