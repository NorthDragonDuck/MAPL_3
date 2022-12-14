package com.example.mapl_3;

import org.junit.Test;

import static org.junit.Assert.*;



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void Test01PlusCheck() {
        String getString = "2+2";
        String expectedResult = "4.0";
       String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test02SubtractCheck() {
        String getString = "2-2";
        String expectedResult = "0.0";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test03MultiplyCheck() {
        String getString = "2*2*4*10*0.5";
        String expectedResult = "80.0";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test04DivisionCheck() {
        String getString = "2/2/4";
        String expectedResult = "0.25";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test05DivisionCheckByZero() {
        String getString = "1/(2/2-1)";
        String expectedResult = "Infinity";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test06DivisionCheckOneDivideX() {
        String getString = "1/(4*4-8-4)";
        String expectedResult = "0.25";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test07DivisionPercentCheck() {
        String getString = "6%(4*4-8-4)";
        String expectedResult = "2.0";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void Test08MultiActionCheckOne() {
        String getString = "1/(2*3-4/2*2)%3";
        String expectedResult = "0.5";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void Test09FalseInputCheck() {

        String getString = "";
        String expectedResult = "false";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test10FalseInputCheck() {

        String getString = "*";
        String expectedResult = "false";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test11FalseInputCheck() {

        String getString = "6/";
        String expectedResult = "false";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test012FalseInputCheck() {

        String getString = "%6";
        String expectedResult = "false";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test13FalseInputCheck() {

        String getString = "2...";
        String expectedResult = "false";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test14FalseInputCheck() {

        String getString = "..2";
        String expectedResult = "false";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test15TrueInputCheck() {

        String getString = "6--4";
        String expectedResult = "true";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test16EqualsOneCheck() {

        String getString = "13";
        String expectedResult = "13.0";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test17FalseInputCheck() {

        String getString = "6**6";
        String expectedResult = "false";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test18TrueInputCheck() {

        String getString = "3*3*6-4/2+4";
        String expectedResult = "true";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void Test19EqualsOneCheck() {

        String getString = "-13";
        String expectedResult = "-13.0";
        String actualResult = String.valueOf(MainActivity.eval(getString));
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void Test20TrueInputCheck() {

        String getString = "1/(-3)++4";
        String expectedResult = "true";
        String actualResult = String.valueOf(MainActivity.checkSysError(getString));
        assertEquals(expectedResult,actualResult);
    }

}