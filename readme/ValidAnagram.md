# Valid Anagram

- **Topic:** Arrays & Hashing
- **Difficulty:** Easy
- **Primary Pattern:** Frequency Counting
- **Language:** Java
- **Testing:** JUnit 5 + CSV-driven test cases

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An anagram contains exactly the same characters with the same frequencies, but possibly in a different order.

### Example 1

**Input**
```text
s = "anagram"
t = "nagaram"
```

**Output:** `true`

**Explanation:** Both strings contain the same characters with identical frequencies.

### Example 2

**Input**
```text
s = "rat"
t = "car"
```

**Output:** `false`

**Explanation:** The strings contain different characters.

---

## Approach 1: Frequency Counting — Primary Solution

**Used in:** `ValidAnagram.java`

### Algorithm

1. If the string lengths differ, return `false`.
2. Create an integer array of size 26 for lowercase English letters.
3. Increment the count for each character in `s`.
4. Decrement the count for each character in `t`.
5. If any count is nonzero, return `false`.
6. Otherwise, return `true`.

### Code

```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }

    int[] freq = new int[26];

    for (int i = 0; i < s.length(); i++) {
        freq[s.charAt(i) - 'a']++;
        freq[t.charAt(i) - 'a']--;
    }

    for (int count : freq) {
        if (count != 0) {
            return false;
        }
    }

    return true;
}
```

### Complexity

- **Time:** `O(n)` — one pass through both strings, followed by a scan of 26 counters.
- **Auxiliary space:** `O(1)` — the array always contains 26 integers.

### Advantages

- Linear time complexity.
- No sorting required.
- Efficient for lowercase English letters.

### Limitation

This implementation assumes every character belongs to `a`–`z`. For uppercase letters, Unicode, or other character sets, use a suitable generalized frequency-counting approach.

---

## Approach 2: Sorting — Alternative for Revision

### Algorithm

1. If the string lengths differ, return `false`.
2. Convert both strings to character arrays.
3. Sort both arrays.
4. Compare the sorted arrays.
5. Return `true` if they match; otherwise, return `false`.

### Code

```java
import java.util.Arrays;

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }

    char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    return Arrays.equals(arr1, arr2);
}
```

### Complexity

- **Time:** `O(n log n)` — sorting dominates.
- **Auxiliary space:** `O(n)` — character arrays are created for both strings.

### Advantages

- Simple to understand and implement.
- Easy to verify by comparing sorted characters.
- Works for arbitrary Java UTF-16 code units when the intended definition of anagram is based on those code units.

### Limitation

Sorting takes longer asymptotically than frequency counting. Unicode grapheme-level anagrams require more careful handling than sorting Java `char` values.

---

## Approach Comparison

| Factor | Frequency Counting | Sorting |
|---|---|---|
| Time | `O(n)` | `O(n log n)` |
| Auxiliary space | `O(1)` for 26 letters | `O(n)` |
| Best fit | Fixed lowercase alphabet | General sorting-based comparison |
| Implementation | Counter array | Two character arrays |
| Repository solution | **Primary** | Reference only |

## Edge Cases

- Identical strings
- Different string lengths
- Repeated characters with different frequencies
- Single-character strings
- Empty strings
- Strings with completely different characters
- Reverse-order alphabet strings

## Testing

The JUnit test class reads cases from:

`src/test/resources/valid-anagram-test-cases.csv`

Run the suite from the Maven project root:

```bash
mvn clean test
```

## Interview Takeaway

Prefer frequency counting when the character set is constrained and performance matters. Sorting is a useful alternative when simplicity is the priority or when a suitable character-level comparison is needed.

Runtime measurements such as 4 ms are environment-dependent; choose the algorithm based on complexity and constraints rather than a particular online-judge timing.
