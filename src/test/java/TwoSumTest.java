
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private final TwoSum solution = new TwoSum();

    @ParameterizedTest(name = "{0}: {1}")
    @CsvFileSource(
            resources = "/two-sum-test-cases.csv",
            numLinesToSkip = 1
    )
    void twoSumShouldHandleTestData(
            String testCaseId,
            String description,
            String numsInput,
            int target,
            String expectedInput) {

        int[] nums = parseArray(numsInput);
        int[] expected = parseArray(expectedInput);

        int[] actual = solution.twoSum(nums, target);

        assertArrayEquals(
                expected,
                actual,
                testCaseId + " - " + description
        );

        if (actual[0] == -1 && actual[1] == -1) {
            assertFalse(hasPair(nums, target),
                    "A valid pair exists: " + testCaseId);
        } else {
            assertTrue(actual[0] >= 0 && actual[0] < nums.length);
            assertTrue(actual[1] >= 0 && actual[1] < nums.length);
            assertNotEquals(actual[0], actual[1]);

            assertEquals(
                    target,
                    nums[actual[0]] + nums[actual[1]]
            );
        }
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

    private boolean hasPair(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
