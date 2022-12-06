package spring.example.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
class TraceableAspect {

    @Around("@annotation(traceable)")
    public Object proceed(ProceedingJoinPoint joinPoint, Traceable traceable) throws Throwable {

        System.out.println(Arrays.toString(joinPoint.getArgs()));

        System.out.println("Input :\n" + joinPoint.getArgs()[0]);
        HttpServletRequest servletRequest = (HttpServletRequest) joinPoint.getArgs()[1];

        System.out.println(servletRequest.getRemoteAddr());

        Object result = joinPoint.proceed();

        System.out.println(result);

        return result;
    }

}