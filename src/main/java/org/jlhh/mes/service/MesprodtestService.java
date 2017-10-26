package org.jlhh.mes.service;

import org.jlhh.mes.repository.MesprodtestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/9/27.
 */
@Service
public class MesprodtestService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MesprodtestRepository mesprodtestRepository;

    public MesprodtestRepository getMesprodtestRepository() {
        return mesprodtestRepository;
    }

    public void setMesprodtestRepository(MesprodtestRepository mesprodtestRepository) {
        this.mesprodtestRepository = mesprodtestRepository;
    }
}
