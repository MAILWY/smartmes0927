package org.jlhh.mes.controller;

import org.jlhh.mes.service.Woald2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyong on 2017/9/27.
 */
@RestController
public class Woald2Controller {
    @Autowired
    private Woald2Service woald2Service;
}

