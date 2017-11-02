package org.jlhh.mes.service;

import org.jlhh.mes.repository.AgvmissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/11/1.
 */
@Service
public class AgvmissionService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AgvmissionRepository agvmissionRepository;

    public AgvmissionRepository getAgvmissionRepository() {
        return agvmissionRepository;
    }

    public void setAgvmissionRepository(AgvmissionRepository agvmissionRepository) {
        this.agvmissionRepository = agvmissionRepository;
    }
}
