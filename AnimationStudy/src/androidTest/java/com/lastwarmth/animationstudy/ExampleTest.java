package com.lastwarmth.animationstudy;

import android.test.InstrumentationTestCase;

/**
 * Author：Jaceli
 * Date：2015/12/4 10:46
 * Description：
 */
public class ExampleTest extends InstrumentationTestCase {
    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }
}
