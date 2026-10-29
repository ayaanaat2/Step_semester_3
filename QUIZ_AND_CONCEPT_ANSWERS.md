# Week 9 — Abstraction, Interface, Class vs Interface (Category C Practice): Quiz and Concept Answers

## Part B — Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | **C** | Abstraction hides how an operation is done and shows only what it does. |
| 2 | **C** | An abstract class cannot be instantiated directly (it need not contain an abstract method, and it extends only one class). |
| 3 | **B** | The subclass must be declared abstract too, otherwise the code does not compile. |
| 4 | **C** `private` | A private method cannot be overridden, so it can never be implemented by a subclass. |
| 5 | **C** | Interface fields are implicitly `public static final`. |
| 6 | **C** | A class can implement any number of interfaces (even while extending another class). |
| 7 | **D** `public` | Interface methods are implicitly public, and an implementation cannot reduce visibility. |
| 8 | **C** | Interfaces carry no instance state, which avoids the diamond problem of conflicting inherited data. |
| 9 | **D** | Two conflicting defaults give a compile-time error until the class overrides the method. |
| 10 | **B** | Abstract classes can have constructors; they run, via `super(...)`, when a subclass object is created. |

## Part C — Concept Questions

**1. Abstraction.** Abstraction means exposing what an object does while hiding how it does it. Example: a coffee machine. The user sees buttons and a cup; the pump, heater, grinder and pressure control are hidden. The user can make coffee without knowing the inside, and the maker can change the inside without changing the buttons.

**2. Abstraction vs encapsulation.** Abstraction is a design view: choose which operations to show. Encapsulation is protection: bundle data with its methods and restrict direct access (private fields). In one class they work together: private fields guard the data (encapsulation) while a small public set of methods presents a simple view of it (abstraction), which keeps both complexity and misuse down.

**3. Constructors in abstract classes.** An abstract class cannot be instantiated, but its fields still need to be initialized for every subclass object. Its constructor runs when a subclass object is created, as the first step of the subclass constructor through `super(...)`, so the shared state (such as the owner's name in a `Plot`) is set up exactly once.

**4. Why `private`, `static`, `final` do not work on abstract methods.**
- `private`: the subclass cannot see or override it, so nobody could ever supply the body.
- `static`: static methods belong to the class and are not overridden, so there is nothing to implement polymorphically.
- `final`: final forbids overriding, but an abstract method exists only to be overridden. The two meanings contradict each other.

**5. Diamond problem.** If class D could extend both B and C, and B and C both inherit and change something from A, D would not know which version (or which copy of A's fields) to use. Java avoids this by allowing only one superclass, so state comes from a single parent. Multiple interfaces are allowed because they carry no instance state, and when two interfaces offer the same default method the class must override it, so the conflict is resolved explicitly at compile time.
