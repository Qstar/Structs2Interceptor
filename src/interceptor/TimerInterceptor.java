package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 计算Action花费的时间
 */
public class TimerInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        //执行Action之前
        long start = System.currentTimeMillis();
        //执行下一个拦截器,如果是最后一个则执行Action
        String result = invocation.invoke();
        //执行Action之后
        long end = System.currentTimeMillis();
        System.out.println("执行Action花费的时间: " + (end - start) + "ms");
        return result;
    }
}
