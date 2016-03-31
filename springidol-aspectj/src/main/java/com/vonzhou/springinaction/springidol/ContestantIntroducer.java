package com.vonzhou.springinaction.springidol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {

    @DeclareParents( //<co id="co_declareParents"/>
            value = "com.vonzhou.springinaction.springidol.Performer+",
            defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}