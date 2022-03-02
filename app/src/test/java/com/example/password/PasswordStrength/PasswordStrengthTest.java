package com.example.password.PasswordStrength;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PasswordStrengthTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //valid
                {"AAAbbbccc@123", 4}
                , {"Hello world$123", 4}
                , {"A!@#&()–a1", 4}               // test punctuation part 1
                , {"A[{}]:;',?/*a1", 4}           // test punctuation part 2
                , {"A~$^+=<>a1", 4}               // test symbols
                , {"0123456789$abcdefgAB", 4}     // test 20 chars
                , {"123Aa$Aa", 4}                  // test 8 chars
                //invalid
                , {"12345678", 2} // invalid, only digit
                , {"abcdefgh", 1} // invalid, only lowercase
                , {"ABCDEFGH", 1} // invalid, only uppercase
                , {"abc123$$$", 3} // invalid, at least one uppercase
                , {"ABC123$$$", 4} // invalid, at least one lowercase
                , {"ABC$$$$$$", 3} // invalid, at least one digit
                , {"java REGEX 12", 4} //  invalid, at least one special character
                , {"java REGEX 123 %", 4} // invalid, % is not in the special character group []
                , {"________", 2} // invalid
                , {" ", 0} // invalid
                , {"", 0} // empty
        });
    }

    @Parameter(0)
    public String fInput;

    @Parameter(1)
    public int fExpected;

    @Test
    public void test() {
        assertEquals(fExpected, PasswordStrength.calculate(fInput).getScore());
    }
}