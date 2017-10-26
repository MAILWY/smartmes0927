package org.jlhh.mes.service;

import org.jlhh.mes.repository.BatterycellRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/9/27.
 */
@Service
public class BatterycellService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BatterycellRepository batterycellRepository;

    public BatterycellRepository getBatterycellRepository() {
        return batterycellRepository;
    }

    public void setBatterycellRepository(BatterycellRepository batterycellRepository) {
        this.batterycellRepository = batterycellRepository;
    }
}
