package kz.iitu.itse1908.springfinalproject.AOPConfiguration;

import kz.iitu.itse1908.springfinalproject.Entities.RequestsLog;
import kz.iitu.itse1908.springfinalproject.Repositories.RequestsLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
@Aspect
public class Logging {

    final
    RequestsLogRepository repository;

    RequestsLog catchedRequest;
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public Logging(RequestsLogRepository repository) {
        this.repository = repository;
    }

    @Pointcut("execution(* kz.iitu.itse1908.springfinalproject.Controllers.CRUD.*.*(..))")
    public void pointCut(){ }


    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        logger.error("STARTING CATCHING REQUEST!");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
        logger.info ("--- request information ---");
        logger.info("remoteAddr: {} ",remoteAddr);
        logger.info("requestURI : {}",requestURI);
        logger.info("Controller : {}", joinPoint.getTarget().getClass());
        logger.info("method type: {}" ,method);
        logger.info ("--- request information ---");
        catchedRequest = new RequestsLog();
        catchedRequest.setController(joinPoint.getTarget().getClass().toString());
        catchedRequest.setRequesturl(requestURI);
        catchedRequest.setRequestmethod(method);
        catchedRequest.setRemoteaddress(remoteAddr);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long millisSinceEpoch = timestamp.getTime();
        Instant instant = Instant.ofEpochMilli(millisSinceEpoch);
        OffsetDateTime dt = OffsetDateTime.ofInstant(instant, ZoneId.of("UTC"));
        catchedRequest.setCreatedat(dt);
        repository.save(catchedRequest);
    }

//    @Around("pointCut()")
//    public void aroundMethod(JoinPoint joinPoint){
//        logger.error("WE HAVE SKIPPED METHOD AROUND!");
//    }

    @AfterReturning("pointCut()")
    public void afterReturningMethod(JoinPoint joinPoint){
        logger.warn("REQUEST HAS BEEN SUCCESSFULLY CAPTURED AND RETURNED INTO DATABASE.");
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        logger.error("FINISHED CATCHING REQUEST!");
    }


    @AfterThrowing("pointCut()")
    public void afterThrowingMethod(JoinPoint joinPoint){
        System.out.println("SOME ERROR HAS HAPPENED");
    }
}
