# Contains Duplicate

- **Topic:** Arrays & Hashing
- **Difficulty:** Easy
- **Pattern:** HashSet / Membership Lookup
- **Language:** Java
- **Testing:** JUnit 5 with CSV-driven test data

## Problem Statement

Given an integer array `nums`, return `true` if any value appears at least twice. Return `false` if every element is distinct.

### Example 1

**Input**
```text
nums = [1, 2, 3, 1]
```

**Output**
```text
true
```

**Explanation:** The number `1` occurs twice.

### Example 2

**Input**
```text
nums = [1, 2, 3, 4]
```

**Output**
```text
false
```

**Explanation:** Every element is distinct.

### Example 3

**Input**
```text
nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
```

**Output**
```text
true
```

## Approach: HashSet

1. Create an empty `HashSet`.
2. Iterate through every number in the array.
3. Attempt to add the number to the set.
4. If `add()` returns `false`, the number already exists; return `true`.
5. If iteration finishes without finding a duplicate, return `false`.

## Complexity Analysis

- **Time complexity:** `O(n)` average
- **Space complexity:** `O(n)` worst case

Here, `n` is the length of the array.

## Edge Cases

- Empty array
- Single-element array
- All elements identical
- Duplicate at the beginning or end
- Adjacent duplicates
- Negative integers
- Zero
- Maximum and minimum Java `int` values
- Null input (implementation-specific behavior)

## Test Strategy

Test cases are maintained in `src/test/resources/contains-duplicate-test-cases.csv` and executed using JUnit 5's `@CsvFileSource`.

The suite covers 12 CSV scenarios plus a separate null-input test.

## Run Tests

From the repository root containing `pom.xml`:

```bash
mvn clean test
```

## Key Learning

Use a `HashSet` when the requirement is to detect duplicates. Use a `HashMap` when the problem requires frequencies, counts, or additional information associated with each value.
