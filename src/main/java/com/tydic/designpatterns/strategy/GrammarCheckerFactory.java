package com.tydic.designpatterns.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * sql语法校验器工厂类
 * @author fancq
 * @date 2019/11/5 22:42
 */
public class GrammarCheckerFactory {
    private static Map<String, GrammarCheckService> grammarCheckerMap = new ConcurrentHashMap<>();

    public static void register(String type, GrammarCheckService grammarCheckService) {
        grammarCheckerMap.put(type, grammarCheckService);
    }

    public GrammarCheckService getGrammarChecker(String type) {
        return grammarCheckerMap.get(type);
    }
}
