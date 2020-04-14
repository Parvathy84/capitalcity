package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputVerificationTest {

    @Test
    void verifyInput() {
        assertAll(
                () -> assertEquals(false, InputVerification.verifyInput("", "")),
                () -> assertEquals(false, InputVerification.verifyInput("sdf", "sdf"))
        );
    }

    @Test
    @DisplayName("CountryName Verifications")
    void verifyInput2() {
        assertAll(
                () -> assertEquals(true, InputVerification.verifyInput("mexico", "")),
                () -> assertEquals(true, InputVerification.verifyInput("test test", "")),
                () -> assertEquals(true, InputVerification.verifyInput("QWERTY", "")),
                () -> assertEquals(false, InputVerification.verifyInput("{{~ QWE", ""))
        );
    }

    @Test
    @DisplayName("CountryCode Verifications")
    void verifyInput3() {
        assertAll(
                () -> assertEquals(true, InputVerification.verifyInput("", "ff")),
                () -> assertEquals(true, InputVerification.verifyInput("", "fqf")),
                () -> assertEquals(true, InputVerification.verifyInput("", "QWE")),
                () -> assertEquals(true, InputVerification.verifyInput("", "QW")),
                () -> assertEquals(false, InputVerification.verifyInput("", "123")),
                () -> assertEquals(false, InputVerification.verifyInput("", "!@#")),
                () -> assertEquals(false, InputVerification.verifyInput("", "22")),
                () -> assertEquals(false, InputVerification.verifyInput("", "pp w")),
                () -> assertEquals(false, InputVerification.verifyInput("", "fdsf"))
        );
    }
}