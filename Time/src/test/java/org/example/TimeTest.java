package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    //Total Seconds
    @Test
//    public void testGetTotalSecondsGood() {
//        int seconds = Time.getTotalSeconds("05:05:05");
//        assertTrue(seconds == 18305, "The seconds were not calculated properly");
//    }
//
//    @Test
//    public void testGetTotalSecondsBad() {
//        assertThrows(StringIndexOutOfBoundsException.class, () -> Time.getTotalSeconds("10:00"));
//    }

//    @ParameterizedTest
//    @ValueSource(strings = { "00:00:00", "23:59:59" })
//    void testGetTotalSecondsBoundary(String candidate) {
//        int expected = candidate.equals("00:00:00") ? 0 : 86399;
//        int seconds = Time.getTotalSeconds(candidate);
//        assertTrue(seconds == expected, "The boundary condition for seconds was not handled properly");
//    }
    //Get Seconds
    public void testGetSecondsGood() {
        int seconds = Time.getSeconds("00:00:59");
        assertTrue(seconds == 59, "The seconds were not calculated properly");
    }

    @Test
    public void testGetSecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Time.getSeconds("00:00"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "00:00:00", "00:00:59" })
    void testGetSecondsBoundary(String candidate) {
        int expected = candidate.equals("00:00:00") ? 0 : 59;
        int seconds = Time.getSeconds(candidate);
        assertTrue(seconds == expected, "The boundary condition for seconds was not handled properly");
    }

    //Total Minutes
    @Test
    public void testGetTotalMinutesGood() {
        int minutes = Time.getTotalMinutes("00:59:00");
        assertTrue(minutes == 59, "The minutes were not calculated properly");
    }

    @Test
    public void testGetTotalMinutesBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Time.getTotalMinutes("00:"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "00:00:00", "00:59:59" })
    void testGetTotalMinutesBoundary(String candidate) {
        int expected = candidate.equals("00:00:00") ? 0 : 59;
        int minutes = Time.getTotalMinutes(candidate);
        assertTrue(minutes == expected, "The boundary condition for minutes was not handled properly");
    }

    //Total Hours
    @Test
    public void testGetTotalHoursGood() {
        int hours = Time.getTotalHours("23:00:00");
        assertTrue(hours == 23, "The hours were not calculated properly");
    }

    @Test
    public void testGetTotalHoursBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Time.getTotalHours(""));
    }

    @ParameterizedTest
    @ValueSource(strings = { "00:00:00", "23:59:59" })
    void testGetTotalHoursBoundary(String candidate) {
        int expected = candidate.equals("00:00:00") ? 0 : 23;
        int hours = Time.getTotalHours(candidate);
        assertTrue(hours == expected, "The boundary condition for hours was not handled properly");
    }
    @Test
    public void testGetMillisecondsGood() {
        int milliseconds = Time.getMilliseconds("12:05:05:005");
        assertEquals(5, milliseconds, "The milliseconds were not calculated properly");
    }

    @Test
    public void testGetMillisecondsBad() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> Time.getMilliseconds("12:05:05"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"00:00:00:000", "23:59:59:999"})
    void testGetMillisecondsBoundary(String candidate) {
        int expected = candidate.equals("00:00:00:000") ? 0 : 999;
        int milliseconds = Time.getMilliseconds(candidate);
        assertEquals(expected, milliseconds, "The boundary condition for milliseconds was not handled properly");
    }
}