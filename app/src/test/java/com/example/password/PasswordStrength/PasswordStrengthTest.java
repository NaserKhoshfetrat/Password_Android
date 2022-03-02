//package com.example.password.PasswordStrength;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.util.stream.Stream;
//
//public class PasswordStrengthTest {
//
//    @Test
//    public void calculate() {
//
//    }
//
//
////    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
////    @MethodSource("validPasswordProvider")
//@Category(UnitTest.class)
//
//    @RunWith(Parameterized.class)
//    void test_password_regex_valid(String password) {
//        assertTrue(PasswordValidator.isValid(password));
//    }
//
//    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
//    @MethodSource("invalidPasswordProvider")
//    void test_password_regex_invalid(String password) {
//        assertFalse(PasswordValidator.isValid(password));
//    }
//
//    @Parameterized.Parameters
//    static Stream<String> validPasswordProvider() {
//        return Stream.of(
//                "AAAbbbccc@123",
//                "Hello world$123",
//                "A!@#&()–a1",               // test punctuation part 1
//                "A[{}]:;',?/*a1",           // test punctuation part 2
//                "A~$^+=<>a1",               // test symbols
//                "0123456789$abcdefgAB",     // test 20 chars
//                "123Aa$Aa"                  // test 8 chars
//        );
//    }
//
//    // At least
//    // one lowercase character,
//    // one uppercase character,
//    // one digit,
//    // one special character
//    // and length between 8 to 20.
//    @Parameterized.Parameters
//    static Stream<String> invalidPasswordProvider() {
//        return Stream.of(
//                "12345678",                 // invalid, only digit
//                "abcdefgh",                 // invalid, only lowercase
//                "ABCDEFGH",                 // invalid, only uppercase
//                "abc123$$$",                // invalid, at least one uppercase
//                "ABC123$$$",                // invalid, at least one lowercase
//                "ABC$$$$$$",                // invalid, at least one digit
//                "java REGEX 123",           // invalid, at least one special character
//                "java REGEX 123 %",         // invalid, % is not in the special character group []
//                "________",                 // invalid
//                "--------",                 // invalid
//                " ",                        // empty
//                "");                        // empty
//    }
//}