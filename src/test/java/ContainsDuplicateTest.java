
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    private final ContainsDuplicate solution = new ContainsDuplicate();

    @ParameterizedTest(name = "{0}: {1}")
    @CsvFileSource(
            resources = "/contains-duplicate-test-cases.csv",
            numLinesToSkip = 1
    )
    void shouldDetectDuplicatesFromTestData(
            String testCaseId,
            String description,
            String numsInput,
            boolean expected) {

        int[] nums = parseArray(numsInput);

        boolean actual = solution.containsDuplicate(nums);

        assertEquals(
                expected,
                actual,
                testCaseId + " - " + description
        );
    }

    @Test
    void shouldReturnFalseForNullArray() {
        assertFalse(solution.containsDuplicate(null));
    }

    private int[] parseArray(String input) {
        if (input == null || input.isBlank()) {
            return new int[0];
        }

        return Arrays.stream(input.split(";"))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
