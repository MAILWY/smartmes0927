package org.jlhh.mes.service;

import org.jlhh.mes.repository.TsaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/9/27.
 */
@Service
public class TsaService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TsaRepository tsaRepository;

    public TsaRepository getTsaRepository() {
        return tsaRepository;
    }

    public void setTsaRepository(TsaRepository tsaRepository) {
        this.tsaRepository = tsaRepository;
    }
}
