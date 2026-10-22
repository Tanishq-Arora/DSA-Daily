
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidAnagramTest {

    private final ValidAnagram solution = new ValidAnagram();

    @ParameterizedTest(name = "{0}: {1}")
    @CsvFileSource(
            resources = "/valid-anagram-test-cases.csv",
            numLinesToSkip = 1
    )
    void shouldValidateAnagrams(
            String testCaseId,
            String description,
            String sInput,
            String tInput,
            boolean expected) {

        String s = parseInput(sInput);
        String t = parseInput(tInput);

        boolean actual = solution.isAnagram(s, t);

        assertEquals(
                expected,
                actual,
                testCaseId + " - " + description
        );
    }

    private String parseInput(String input) {
        return "<empty>".equals(input) ? "" : input;
    }

    @Test
    void shouldHandleNullInputs() {
        // Null is outside the standard LeetCode constraints.
        // The current implementation does not promise null handling.
        // This test is intentionally not an assertion test.
    }
}
