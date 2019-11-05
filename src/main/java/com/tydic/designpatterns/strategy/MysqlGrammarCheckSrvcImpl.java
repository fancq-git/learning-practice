package com.tydic.designpatterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * mysql脚本语法校验服务
 * @author fancq
 * @date 2019/11/5 22:48
 */
@Service("mysqlGrammarCheck")
public class MysqlGrammarCheckSrvcImpl extends GrammarCheckService implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlGrammarCheckSrvcImpl.class);

    @Override
    public void check(String sql) {
        LOGGER.info("校验mysql脚本语法正确性");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        GrammarCheckerFactory.register("mysqlGrammarCheck", this);
    }
}
