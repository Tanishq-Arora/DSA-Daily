# Product of Array Except Self

- **Topic:** Arrays & Hashing
- **Difficulty:** Medium
- **Pattern:** Prefix Product + Suffix Product
- **Language:** Java
- **Testing:** JUnit 5 + CSV test data

## 1. Problem Statement

Given an integer array `nums`, return an array `answer` where:

`answer[i]` is the product of every element in `nums` except `nums[i]`.

**Constraints to remember:**
- Do not use division.
- Aim for `O(n)` time complexity.
- Assume the products fit within the Java `int` range.

### Example

Input: `[1, 2, 3, 4]`

Output: `[24, 12, 8, 6]`

Explanation:
- Index 0: `2 × 3 × 4 = 24`
- Index 1: `1 × 3 × 4 = 12`
- Index 2: `1 × 2 × 4 = 8`
- Index 3: `1 × 2 × 3 = 6`

---

## 2. Approach 1 — Brute Force

### Idea

For each index, multiply all elements except the current element.

```java
for (int i = 0; i < nums.length; i++) {
    int product = 1;

    for (int j = 0; j < nums.length; j++) {
        if (i != j) {
            product *= nums[j];
        }
    }

    answer[i] = product;
}
```

### Complexity

- Time: `O(n²)`
- Auxiliary space: `O(1)`, excluding the output array.

### Why optimize?

Each element is multiplied repeatedly. We can avoid this repeated work by remembering products from the left and right.

---

## 3. Approach 2 — Prefix and Suffix Products

**This is the optimized approach implemented in `ProductExceptSelf.java`.**

### Core insight

For any index:

`answer[i] = product of elements to the left × product of elements to the right`

Instead of recalculating every product, reuse the results of previous iterations.

### Pass 1 — Prefix products

Traverse from left to right.

Store the product of all elements before the current index.

For `[2, 3, 4, 5]`:

| Index | Current value | Prefix stored | Prefix after update |
|---:|---:|---:|---:|
| 0 | 2 | 1 | 2 |
| 1 | 3 | 2 | 6 |
| 2 | 4 | 6 | 24 |
| 3 | 5 | 24 | 120 |

The result array becomes `[1, 2, 6, 24]`.

Why start with `1`? Because the first element has no elements to its left, and `1` is the identity for multiplication.

### Pass 2 — Suffix products

Traverse from right to left.

Multiply each stored prefix product by the product of all elements to its right.

| Index | Prefix stored | Suffix before update | Final result |
|---:|---:|---:|---:|
| 3 | 24 | 1 | 24 |
| 2 | 6 | 5 | 30 |
| 1 | 2 | 20 | 40 |
| 0 | 1 | 60 | 60 |

Final output: `[60, 40, 30, 24]`.

### Complexity

- Time: `O(n)` — two traversals.
- Auxiliary space: `O(1)`, excluding the output array.
- Output space: `O(n)`.

### Why is this smart?

The output array itself stores the prefix products. A single variable stores the running suffix product. No additional prefix or suffix arrays are needed.

---

## 4. Approach 3 — Separate Prefix and Suffix Arrays

**Reference approach only; not used in the implementation.**

Create separate arrays for the left and right products, then multiply corresponding positions.

```java
int n = nums.length;

int[] prefix = new int[n];
int[] suffix = new int[n];
int[] answer = new int[n];

prefix[0] = 1;

for (int i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] * nums[i - 1];
}

suffix[n - 1] = 1;

for (int i = n - 2; i >= 0; i--) {
    suffix[i] = suffix[i + 1] * nums[i + 1];
}

for (int i = 0; i < n; i++) {
    answer[i] = prefix[i] * suffix[i];
}
```

### Complexity

- Time: `O(n)`
- Auxiliary space: `O(n)` for the prefix and suffix arrays.

### Advantages

- Easy to visualize and debug.
- Left and right products can be inspected independently.

### Disadvantage

- Uses more memory than the optimized implementation.

---

## 5. Edge Cases

| Input | Expected output |
|---|---|
| `[1, 2, 3, 4]` | `[24, 12, 8, 6]` |
| `[1, 2, 0, 4]` | `[0, 0, 8, 0]` |
| `[0, 2, 0, 4]` | `[0, 0, 0, 0]` |
| `[-1, -2, -3]` | `[-6, -3, -2]` |
| `[7]` | `[1]` |
| `[]` | `[]` |

Zeros work naturally without division or special zero-handling logic.

## 6. Common Mistakes

1. Updating the prefix before storing it, thereby including the current element.
2. Updating the suffix before multiplying the current result, also including the current element.
3. Using division, which is unsuitable when the array contains zeros.
4. Claiming `O(1)` total space without excluding the output array.
5. Ignoring integer overflow: Java `int` multiplication can overflow for large products.

## 7. Testing

CSV file:

`src/test/resources/product-except-self-test-cases.csv`

Run all Maven tests from the repository root:

```bash
mvn clean test
```

The test class loads each CSV row and checks the expected array.

## 8. Interview Takeaway

When a problem asks for the product of all elements except the current element:

1. Write the brute-force solution first.
2. Identify repeated multiplication.
3. Split the calculation into left and right products.
4. Reuse prefix products and a running suffix product.
5. Check zeros, negative numbers, single-element arrays and overflow constraints.
