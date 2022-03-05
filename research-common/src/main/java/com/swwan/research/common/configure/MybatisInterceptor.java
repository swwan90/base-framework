//package com.swwan.research.common.configure;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.javassist.bytecode.analysis.Executor;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.mapping.SqlCommandType;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Signature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Field;
//
///**
// * 插入数据的拦截器处理
// *
// * @author swwan
// * @date 2022/1/16 - 17:38
// * @see {https://www.cnblogs.com/buguge/p/13749101.html}
// */
//@Slf4j
//@Component
//@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
//public class MybatisInterceptor implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
//        String sqlId = mappedStatement.getId();
//        log.debug("------sqlId------" + sqlId);
//        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
//        Object parameter = invocation.getArgs()[1];
//        log.debug("------sqlCommandType------" + sqlCommandType);
//
//        if (parameter == null) {
//            return invocation.proceed();
//        }
//        if (SqlCommandType.INSERT == sqlCommandType || SqlCommandType.UPDATE == sqlCommandType) {
//            Field[] fields = ConvertUtils.getAllFields(parameter);
//            for (Field field : fields) {
//                if (field.getType().equals(String.class)) {
//                    field.setAccessible(true);
//                    Object o = field.get(parameter);
//                    field.setAccessible(false);
//                    String newVal = o == null ? "" : String.valueOf(o).trim();
//                    field.setAccessible(true);
//                    field.set(parameter, newVal);
//                    field.setAccessible(false);
//                }
//            }
//        }
//
//        return invocation.proceed();
//    }
//
//}
