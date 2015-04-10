package com.thinknear.attribution.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import com.thinknear.attribution.annotation.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kennethr on 4/9/15.
 */
@Aspect
@Component
public class ProfilerAspect {

    static final Logger logger = LoggerFactory.getLogger(ProfilerAspect.class);

    @Around("@annotation(profile)")
    public Object doBasicProfiling(ProceedingJoinPoint pjp, Profile profile) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            Object retVal = pjp.proceed();
            return retVal;
        } catch (Throwable t) {
            throw t;
        } finally {
            logger.info(profile.value() + ": " + (System.currentTimeMillis() - startTime) + "ms");
        }
    }
}
