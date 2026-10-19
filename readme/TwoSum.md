# Two Sum

**Topic:** Arrays & Hashing  
**Difficulty:** Easy  
**Pattern:** HashMap / Complement Lookup

## Problem Statement

Given an integer array `nums` and an integer `target`, return the indices of two distinct elements whose sum equals the target.

### Example 1

**Input**
```text
nums = [2, 7, 11, 15]
target = 9
```

**Output**
```text
[0, 1]
```

**Explanation:** `nums[0] + nums[1] = 2 + 7 = 9`.

### Example 2

**Input**
```text
nums = [3, 2, 4]
target = 6
```

**Output**
```text
[1, 2]
```

### Example 3

**Input**
```text
nums = [3, 3]
target = 6
```

**Output**
```text
[0, 1]
```

## Approach: HashMap

1. Create a HashMap to store each previously visited number and its index.
2. Iterate through the input array.
3. Calculate the complement: `target - nums[i]`.
4. If the complement exists in the map, return its stored index and the current index.
5. Otherwise, store the current number and index.
6. If no valid pair exists, return `[-1, -1]`.

## Complexity Analysis

- **Time:** O(n) average
- **Space:** O(n)

## Edge Cases

- Duplicate numbers
- Negative numbers
- Zero values
- Negative target
- No valid pair
- Empty array
- Single-element array
- Multiple valid pairs

## Key Learning

Store `number → index`, not just the complement. Check for the complement before inserting the current element to prevent using the same index twice.

## Run Tests

If using the JUnit 5 and Maven setup:

```bash
mvn test
```
