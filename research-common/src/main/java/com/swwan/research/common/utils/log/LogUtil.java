package com.swwan.research.common.utils.log;

/**
 * 日志相关工具类
 *
 * @author swwan
 * @date 2022/2/15 - 22:48
 */
public class LogUtil {

    /**
     * 获取以指定包名为前缀的堆栈信息
     *
     * @param e             异常
     * @param packagePrefix 包前缀
     * @return 堆栈信息
     */
    public static String getStacktraceByPn(Throwable e, String packagePrefix) {
        StringBuilder builder = new StringBuilder("\n").append(e);
        for (StackTraceElement traceElement : e.getStackTrace()) {
            if (!traceElement.getClassName().startsWith(packagePrefix)) {
                continue;
            }
            builder.append("\n\tat ").append(traceElement);
        }
        return builder.toString();
    }
}
