
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfTest {

    private final ProductExceptSelf solution = new ProductExceptSelf();

    @ParameterizedTest(name = "{0}: {1}")
    @CsvFileSource(
            resources = "/product-except-self-test-cases.csv",
            numLinesToSkip = 1
    )
    void shouldCalculateProductExceptSelf(
            String testCaseId,
            String description,
            String numsInput,
            String expectedInput) {

        int[] nums = parseArray(numsInput);
        int[] expected = parseArray(expectedInput);

        assertArrayEquals(
                expected,
                solution.productExceptSelf(nums),
                testCaseId + " - " + description
        );
    }

    @Test
    void shouldRejectNullInput() {
        assertThrows(
                IllegalArgumentException.class,
                () -> solution.productExceptSelf(null)
        );
    }

    private int[] parseArray(String input) {
        if (input == null || input.isBlank()
                || "<empty>".equals(input.trim())) {
            return new int[0];
        }

        return Arrays.stream(input.split(";"))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
