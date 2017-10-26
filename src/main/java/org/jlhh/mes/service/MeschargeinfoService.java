package org.jlhh.mes.service;

import org.jlhh.mes.repository.MeschargeinfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/9/27.
 */
@Service
public class MeschargeinfoService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MeschargeinfoRepository meschargeinfoRepository;

    public MeschargeinfoRepository getMeschargeinfoRepository() {
        return meschargeinfoRepository;
    }

    public void setMeschargeinfoRepository(MeschargeinfoRepository meschargeinfoRepository) {
        this.meschargeinfoRepository = meschargeinfoRepository;
    }
}
