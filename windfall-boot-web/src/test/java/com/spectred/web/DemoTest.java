package com.spectred.web;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class DemoTest {

    private static final Map<String, Predicate> map = new HashMap<>();

    static {

        Predicate<Integer> ap = x -> x >= 90 && x < 100;
        Predicate<Integer> bp = x -> x >= 80 && x < 90;
        Predicate<Integer> cp = x -> x >= 60 && x < 80;
        Predicate<Integer> dp = x -> x >= 0 && x < 60;
        map.put("A", ap);
        map.put("B", bp);
        map.put("C", cp);
        map.put("D", dp);
    }

    @Test
    public void test() {
        map.forEach((k, v) -> {
            if (v.test(99)) {
                TestCase.assertEquals("A", k);
            }
        });
    }


}
