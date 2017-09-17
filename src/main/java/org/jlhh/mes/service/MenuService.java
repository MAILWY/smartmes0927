package org.jlhh.mes.service;

import org.jlhh.mes.repository.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangjialin on 2017/9/17.
 */
@Service
public class MenuService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MenuRepository menuRepository;

    public MenuRepository getMenuRepository() {
        return menuRepository;
    }

    public void setMenuRepository(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
}
