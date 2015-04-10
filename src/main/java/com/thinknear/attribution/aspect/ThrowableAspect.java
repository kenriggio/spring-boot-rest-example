package com.thinknear.attribution.aspect;

import com.thinknear.attribution.annotation.Throwit;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kennethr on 4/9/15.
 */
@Aspect
@Component
public class ThrowableAspect {

    static final Logger logger = LoggerFactory.getLogger(ThrowableAspect.class);

    @AfterThrowing(
            pointcut="@annotation(throwit)",
            throwing="t")
    public Object reportThrowable(Throwit throwit, Throwable t) throws Throwable {

        logger.info(t.getClass() + ": " + t.getMessage());
        throw t;
    }
}
