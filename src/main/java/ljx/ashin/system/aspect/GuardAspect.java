package ljx.ashin.system.aspect;

import ljx.ashin.system.exception.INFException;
import ljx.ashin.system.exception.InfError;
import ljx.ashin.utils.MathTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.io.IOException;
import java.util.Set;



/**
 * Created by AshinLiang on 2017/7/23.
 */
@Slf4j
@Aspect
public class GuardAspect {

    @Resource
    private Validator validator;

    @Around("execution(public * ljx.ashin.service..*.*(*))")
    public Object exceptionAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 生成一个keep值作为线程名，用于跟踪日志，生成规则为时间戳加4位随机数
        String keep = System.currentTimeMillis() + MathTool.get4RandomNumber();
        Thread.currentThread().setName(keep);

        Object proceed = null;
        try {
            String method = joinPoint.getSignature().getName();
            String api = joinPoint.getSignature().getDeclaringTypeName();
            String impl = joinPoint.getTarget().toString();

            log.info("service api   : " + api);
            log.info("service impl  : " + impl);
            log.info("method        : " + method);

            Object[] args = joinPoint.getArgs();
            Object reqObj = args[0];
            if (reqObj != null) {
                log.info("request param : " + ToStringBuilder.reflectionToString(reqObj));
                Set<ConstraintViolation<Object>> validate = validator.validate(reqObj, Default.class);
                StringBuilder sb = new StringBuilder();
                sb.append(" 字段校验错误 ——");
                for (ConstraintViolation<Object> cv : validate) {
                    sb.append((cv.getPropertyPath() + ","
                            + cv.getInvalidValue() + ":" + cv.getMessage() + ";"));
                }
                if (validate.size() > 0) {
                    log.info(sb.toString());
                    throw new INFException(InfError.FiledInvalid.getCode(), sb.toString());
                }
                proceed = joinPoint.proceed();
            }

        }catch (IOException e){
            log.error("调用接口服务未连接", e);
            throw new INFException(InfError.CALL_CORE_CONNECT_FAIL.getCode(),
                    InfError.CALL_CORE_CONNECT_FAIL.getReason());
        }
        if (proceed instanceof String)
            log.info("response param: " + proceed);
        else
            log.info("response param: " + ToStringBuilder.reflectionToString(proceed));
        return proceed;
    }

}
