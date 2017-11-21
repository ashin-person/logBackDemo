package ljx.ashin.system;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sun.webpane.platform.ConfigManager.log;

/**
 * Created by AshinLiang on 2017/7/23.
 */

@Aspect
public class GuardAspect {

/*    @Before("execution(* ljx.ashin.service.*.*.*(..))")
    public Object printLogMsg(JoinPoint joinPoint){

        Object[] params = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("===调用service的"+methodName+"方法，参数为"+params[0].toString()+"===");
        return null;
    }*/

    private Logger logger = LoggerFactory.getLogger(GuardAspect.class);

    @Around("execution(* ljx.ashin.service.*.*.*(..))")
 /*   *
     * 数据校验*/
    public Object validataAround(ProceedingJoinPoint proceedingJoinPoint){
        Object obj = null;
        try {
            obj= proceedingJoinPoint.proceed();
            Object[] params = proceedingJoinPoint.getArgs();
            String methodName = proceedingJoinPoint.getSignature().getName();
            String targetClassName = proceedingJoinPoint.getTarget().getClass().getName().toString();
            logger.info("调用类:{}",targetClassName);
            logger.info("===调用{}方法，参数为:{}",methodName,params[0].toString());
//            logger.info(proceedingJoinPoint.getTarget().getClass().getName());
            logger.info("响应参数:{}",obj.toString());

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

//        proceedingJoinPoint.

        return obj;
    }

    /**
     * 检验是否为空
     * @param params
     */
    private void validateParams(Object[] params){

    }
}
