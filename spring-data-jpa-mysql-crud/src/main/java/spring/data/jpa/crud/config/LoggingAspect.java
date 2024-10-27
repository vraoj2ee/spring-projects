package spring.data.jpa.crud.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Define a Pointcut that matches all methods in EmployeeServiceImpl
    @Pointcut("execution(* spring.data.jpa.crud..*(..))")
    public void employeeServiceMethods() {
    }

    // Use @Around advice to log the method execution
    @Around("employeeServiceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Method {} started with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());

        Object result;
        try {
            result = joinPoint.proceed();  // Execute the target method
        } catch (Exception e) {
            logger.error("Exception in method {}: {}", joinPoint.getSignature(), e.getMessage());
            throw e;
        }

        long endTime = System.currentTimeMillis();
        logger.info("Method {} finished in {} ms with result: {}", joinPoint.getSignature(), (endTime - startTime), result);

        return result;
    }
}