package org.jlhh.mes.utils;

import org.jlhh.mes.service.IBusiness;
import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by wangjialin on 2017/10/10.
 */
public class AcUtils {
    private static ConfigurableApplicationContext cac;

    public static void initCac(ConfigurableApplicationContext cac) {
        AcUtils.cac = cac;
    }

    public static IBusiness getBusinessObject(String tradeCode) {
        IBusiness businessObject = null;
        try {
            businessObject = cac.getBean(tradeCode, IBusiness.class);
        } catch (BeansException ex) {
            ex.printStackTrace();
        }
        return businessObject;
    }
}
