# Exercise 7: Financial Forecasting

## Objective

The objective of this exercise is to develop a financial forecasting tool that predicts future values based on historical growth rates using a recursive algorithm. This exercise demonstrates the application of recursion in solving real-world financial problems and analyzes its efficiency.

---

# 1. Understanding Recursive Algorithms

## What is Recursion?

Recursion is a programming technique in which a method calls itself to solve a smaller version of the same problem. A recursive algorithm continues calling itself until it reaches a base condition, which stops further recursive calls.

A recursive solution generally consists of:

1. **Base Case** – The condition that terminates recursion.
2. **Recursive Case** – The part where the method calls itself with a smaller input.

### Example

Factorial Calculation:

* Factorial(5) = 5 × Factorial(4)
* Factorial(4) = 4 × Factorial(3)
* ...
* Factorial(1) = 1

Here, Factorial(1) is the base case.

---

## How Recursion Simplifies Certain Problems

Recursion simplifies problems that can be broken into smaller subproblems of the same type.

Advantages include:

* Produces cleaner and more readable code.
* Eliminates the need for complex loops in some situations.
* Naturally fits problems involving repeated calculations.
* Useful for mathematical computations, tree traversal, divide-and-conquer algorithms, and forecasting models.

In financial forecasting, future values can be calculated recursively because the value for a given year depends on the value from the previous year.

---

# 2. Financial Forecasting Using Recursion

## Problem Statement

Predict the future value of an investment based on a fixed annual growth rate.

### Formula

Future Value:

FV = PV × (1 + r)^n

Where:

* FV = Future Value
* PV = Present Value
* r = Growth Rate
* n = Number of Years

### Recursive Representation

FV(n) = FV(n − 1) × (1 + r)

Base Case:

FV(0) = Present Value

This recursive relationship makes financial forecasting a suitable application of recursion.

---

# 3. Recursive Algorithm

## Algorithm Steps

1. Accept the current value, growth rate, and number of years.
2. If the number of years is 0, return the current value.
3. Otherwise:

   * Calculate the future value for the previous year.
   * Multiply it by (1 + growth rate).
4. Return the result.

### Recursive Logic

predictFutureValue(value, rate, years)

If years == 0

 Return value

Else

 Return predictFutureValue(value, rate, years - 1) × (1 + rate)

---

# 4. Time Complexity Analysis

## Time Complexity

Let n represent the number of years.

For every recursive call, the years value decreases by one.

The recurrence relation is:

T(n) = T(n − 1) + O(1)

Solving this relation gives:

Time Complexity = O(n)

This means the algorithm performs one recursive call for each year.

### Example

For 5 years:

* Call 1 → years = 5
* Call 2 → years = 4
* Call 3 → years = 3
* Call 4 → years = 2
* Call 5 → years = 1
* Call 6 → years = 0

Total recursive calls = 6

Therefore, execution time grows linearly with the number of years.

---

## Space Complexity

Each recursive call is stored in the call stack.

Space Complexity = O(n)

This is because n recursive calls may exist simultaneously before the recursion begins returning results.

---

# 5. Optimization of Recursive Solution

## Problem with Basic Recursion

Although recursion provides a simple and elegant solution, it has some disadvantages:

* Increased memory usage due to recursive call stack.
* Additional overhead from repeated function calls.
* Risk of StackOverflowError for very large inputs.

---

## Optimization Method 1: Iterative Approach

Instead of recursion, a loop can be used.

Advantages:

* Eliminates recursive call overhead.
* Requires constant memory.
* More efficient for large values of n.

Complexities:

* Time Complexity: O(n)
* Space Complexity: O(1)

---

## Optimization Method 2: Mathematical Formula

Use the compound growth formula directly:

Future Value = Present Value × (1 + Growth Rate)^Years

In Java:

Math.pow(1 + growthRate, years)

Advantages:

* Fastest approach.
* Minimal memory usage.
* Simple implementation.

Complexities:

* Time Complexity: O(1) (practically constant)
* Space Complexity: O(1)

This is the preferred solution for real-world financial forecasting systems.

---

# Conclusion

This exercise demonstrated how recursion can be applied to financial forecasting by calculating future values based on annual growth rates. The recursive solution is easy to understand and closely follows the mathematical relationship between present and future values. The recursive algorithm has a time complexity of O(n) and a space complexity of O(n). For better performance and lower memory usage, iterative solutions or direct mathematical formulas such as Math.pow() can be used as optimizations.
