package com.swwan.research.common.configure;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.javassist.bytecode.analysis.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import sun.plugin2.main.server.ResultHandler;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 查询数据的拦截器处理
 *
 * @author swwan
 * @date 2022/1/16 - 17:35
 * @see {https://www.cnblogs.com/buguge/p/13749101.html}
 */
@Slf4j
@Component
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})})

public class MybatisQueryInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String sqlId = mappedStatement.getId();
        log.debug("------sqlId------" + sqlId);
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        log.debug("------sqlCommandType------" + sqlCommandType);

        Object parameter = invocation.getArgs()[1];
        if (parameter == null || SqlCommandType.SELECT != sqlCommandType) {
            return invocation.proceed();
        }

        if (parameter instanceof MapperMethod.ParamMap
                && ((MapperMethod.ParamMap) parameter).get("ew") instanceof AbstractWrapper) {
            Map nameValuePairs = ((AbstractWrapper) ((MapperMethod.ParamMap) parameter).get("ew")).getParamNameValuePairs();

            Iterator<Map.Entry<String, Object>> iterator = nameValuePairs.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                if (next.getValue() instanceof String) {
                    next.setValue(((String) next.getValue()).trim());
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // TODO Auto-generated method stub
    }
}
