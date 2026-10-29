# Week 10 — Category C Practice: Quiz and Concept Answers

## Part B — Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | **D** | Two `new String(...)` objects are different objects (`==` false) with equal content (`equals` true). |
| 2 | **B** `"baL avaJ"` | "Java Lab" reversed character by character. |
| 3 | **B** | `new Student("Ravi")` calls `Student(String name)` directly, which then chains to the two-argument one. |
| 4 | **D** | `w1` and `w2` refer to the same object, so both show 700. |
| 5 | **C** | The static counter is shared: 3. |
| 6 | **A** | `45 78 92 60 85` |
| 7 | **B** | `continue` skips 3: `1 2 4 5` |
| 8 | **A** | Java passes primitives by value, so `x` stays 5. |
| 9 | **C** | `250 / 3.0` is `83.33333333333333` (checked by running it). |
| 10 | **B** | 500 + 2% fee = `Paid 510.0 by card`. |
| 11 | **B** | Strings are immutable: `name` stays "java" and a new String "JAVA" is created. |
| 12 | **B** | One pooled "hello" shared by `s1` and `s2`, plus the separate object from `new String("hello")`. |
| 13 | **A** | "Campus" has length 6, and `charAt(2)` is `m`. |
| 14 | **A** | `indexOf("@")` in `user@domain.com` is 4. |
| 15 | **B** | `Title: Unknown, Price: 0.0` |
| 16 | **A** | `Title: Java Programming, Price: 450.0` |
| 17 | **B** | `w1` and `w2` share one object, `w3` is a second: 2 objects. |
| 18 | **C** | Both references show 700. |
| 19 | **C** | Only `s1` changed: `Anu` / `Ravi`. |
| 20 | **C** | `Total visitors: 3` |

## Part C — Concept Questions

**1. String immutability.** A `String` cannot be changed after creation; every "modification" (concat, replace, toUpperCase) builds a new object. Repeated changes in a loop create many short-lived objects and copy characters each time, which is slow and wasteful. Use `StringBuilder` (or `StringBuffer` when thread safety is needed) so the same buffer is edited in place.

**2. `this` keyword.** When a parameter has the same name as a field, the parameter shadows the field. `this.name = name;` means "set the object's field `name` to the parameter `name`". Without `this`, `name = name;` would assign the parameter to itself and leave the field unchanged.

**3. Object vs reference variable.** The object lives on the heap; a reference variable holds a way to reach it. `Wallet w2 = w1;` copies the reference, not the object, so both variables point to the same object and a change through one is visible through the other. Only `new` creates another object.

**4. Static vs instance variables.** A static variable belongs to the class and has one copy shared by all objects (a visitor counter or the college name). An instance variable belongs to each object (a student's name or marks). Use static for data that is common to the whole class, and instance for data that differs per object.

**5. for, while, do-while.** `for` suits a known number of iterations (walking an array). `while` suits repeating until a condition becomes false when the count is unknown (reading input until the end). `do-while` runs the body at least once before checking (a menu that must be shown once and repeated until the user quits).

**6. Pass-by-value.** Java always passes a copy of the argument. For a primitive, the method gets a copy of the value, so changing it never affects the caller. For an object, the copy is of the reference: the method can change the object's contents through it (the caller sees that), but reassigning the parameter to a new object does not change the caller's variable.

**7. Integer division.** When both operands are integers, the result is an integer and the fractional part is dropped (`7 / 2` is 3). To get a precise result, convert at least one operand to `double` (`(double) total / count`, or `total / 2.0`) before the division happens.

**8. Encapsulation.** Encapsulation bundles data and the methods that work on it and hides the fields. With `private` fields and public getters and setters, outside code can only reach the data through methods that can validate it (reject negative balances, enforce limits). That keeps the object's state consistent and lets the internals change without breaking callers.

**9. `==` vs `equals()`.** `==` on objects compares references (are these the same object?). `equals()` compares content when the class defines it, as `String` does. By default `Object.equals()` behaves like `==`; overriding it (and `hashCode()`) lets two separate objects with equal fields count as equal, for example two `IdCard` objects with the same name and ID.

**10. Overloading vs overriding.** Overloading means several methods with the same name but different parameter lists in one class; the compiler picks one at compile time (`add(int, int)` and `add(double, double)`). Overriding means a subclass replaces an inherited method with the same signature; the JVM chooses the version at run time from the actual object (`Card.pay()` overriding `Payment.pay()`).
