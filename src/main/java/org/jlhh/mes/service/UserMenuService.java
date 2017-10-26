package org.jlhh.mes.service;

import org.jlhh.mes.repository.UserMenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyong on 2017/9/27.
 */
@Service
public class UserMenuService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMenuRepository userMenuRepository;

    public UserMenuRepository getUserMenuRepository() {
        return userMenuRepository;
    }

    public void setUserMenuRepository(UserMenuRepository userMenuRepository) {
        this.userMenuRepository = userMenuRepository;
    }
}
