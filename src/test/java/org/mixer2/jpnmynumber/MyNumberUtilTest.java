package org.mixer2.jpnmynumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyNumberUtilTest {

    @Test
    public void testVerifyCorporationNumber() throws Exception {
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008840"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008841"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008842"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008843"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008844"));
        assertTrue(MyNumberUtil.verifyCorporationNumber("6010001008845"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008846"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008847"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008848"));
        assertFalse(MyNumberUtil.verifyCorporationNumber("6010001008849"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testVerifyCorporationNumberException0() throws Exception {
        MyNumberUtil.verifyCorporationNumber("0123456z78900");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifyCorporationNumberException1() throws Exception {
        MyNumberUtil.verifyCorporationNumber("012345678900z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifyCorporationNumberException_null() throws Exception {
        MyNumberUtil.verifyCorporationNumber(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifyCorporationNumberException_empty() throws Exception {
        MyNumberUtil.verifyCorporationNumber("");
    }

    @Test
    public void testVerifyMyNumber() throws Exception {
        assertFalse(MyNumberUtil.verifyMyNumber("123456789010"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789011"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789012"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789013"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789014"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789015"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789016"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789017"));
        assertTrue(MyNumberUtil.verifyMyNumber("123456789018"));
        assertFalse(MyNumberUtil.verifyMyNumber("123456789019"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifyMyNumberException0() throws Exception {
        MyNumberUtil.verifyMyNumber("0123456z78900");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifyMyNumberException1() throws Exception {
        MyNumberUtil.verifyMyNumber("012345678900z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifyMyNumberException_null() throws Exception {
        MyNumberUtil.verifyMyNumber(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVerifyMyNumberException_empty() throws Exception {
        MyNumberUtil.verifyMyNumber("");
    }
}
