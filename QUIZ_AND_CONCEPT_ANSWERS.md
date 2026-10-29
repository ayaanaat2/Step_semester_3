# Week 8 — Inheritance & Polymorphism (Category C Practice): Quiz and Concept Answers

## Part B — Quiz

| Q | Answer | Why |
|---|--------|-----|
| 1 | **C** Polymorphism | One `render()` call on the `Document` type picks the right version at run time, so the type-checking if-else blocks disappear. |
| 2 | **A, B** | A car is a vehicle and a rectangle is a shape. D is has-a (composition). C is debatable: a connection *uses* a network resource more than it *is* one. |
| 3 | **C** Runtime method dispatch | The JVM looks at the real object, not the reference type, when `startEngine()` is called. |
| 4 | **C** Inheritance-based polymorphism | One base-type list, each element runs its own `calculateArea()`. |
| 5 | **A, C, D** | `Book` extends inherited behavior (A), `LibraryItem` holds the common behavior (C), and a `DVD` can be used through a `LibraryItem` reference (D). B is wrong: the DVD sets its own fixed period, so that is specialized, not shared, behavior. |
| 6 | **A, C** | A `Dog` behind an `Animal` reference runs `Dog.makeSound()` (A), and `Dog`'s version is overridden behavior (C). B is wrong (the base version is the general one) and D is wrong (subclasses can add brand-new methods). |
| 7 | **C** | `WalletPayment` can be added without touching the processor's loop. |
| 8 | **A** | Reuse without a real is-a relationship couples unrelated classes and gives a wrong, rigid hierarchy. |
| 9 | **A, C** | The sender works with the base type, and new channels are added without changing it. B and D describe the opposite of what polymorphism does. |
| 10 | **A, B, C** | D is wrong: polymorphic collections make new derived types *easier* to add. |

## Part C — Concept Questions

**1. Reuse and extend.** A subclass inherits fields and methods from its base class, so common code is written once. It can then add new members or override a method to change the behavior. Example: `Employee` holds name and ID; `Manager extends Employee` inherits both and adds a team list and a bigger bonus rule.

**2. The is-a relationship.** Inheritance should model "X is a kind of Y" (a `Car` is a `Vehicle`). Getting it right matters because every subclass object must be usable wherever the base type is expected. A false is-a (a `Stack` extending `ArrayList`) exposes methods that break the class's rules and locks the design into a hierarchy that does not fit.

**3. Method overriding.** A subclass provides its own body for a method with the same signature as one in its base class. `Employee.calculateSalary()` can return a fixed amount for a `FullTimeEmployee`, hours times rate for an `HourlyEmployee`, and a stipend for an `Intern`. Callers use one method name and each type answers in its own way.

**4. Runtime polymorphism (dynamic dispatch).** When a method is called through a base-type reference, Java chooses the implementation from the actual object type at run time, using the object's class and its method table. The reference type only decides which methods may be called; the object decides which version runs.

**5. Polymorphic collections.** A `List<Payment>` can hold `CardPayment`, `WalletPayment` and `BankTransferPayment` objects. A single loop calls `calculateFee()` on each element and every object applies its own rule. This removes type checks, keeps the loop short, and works for types added later.

**6. Polymorphism vs if-else chains.** An if-else or switch on type puts the knowledge of every type in one place, so each new type means editing that chain (and every other chain like it). With overriding, each class owns its rule and the calling code never changes. That is why polymorphism is preferred: less duplication, fewer missed cases, and the open/closed principle is respected.

**7. Adding a new type.** If the processor depends only on `PaymentMethod`, a new `UpiPayment extends PaymentMethod` with its own `calculateFee()` can be added and passed into the existing list. The processing loop is not modified or even recompiled in logic terms, because it only calls the common method.

**8. Inherited vs overridden behavior.** A subclass inherits a method when the base version is already correct (`getName()` on every `Employee`). It overrides a method when its rule differs (`calculateBonus()` for an intern). Inherit what is common, override what is specific.

**9. Inheritance only for code reuse.** Extending a class just to borrow its code, with no real is-a relationship, creates tight coupling, exposes inappropriate methods, and makes later changes to the base class break unrelated subclasses. Composition (holding the other object as a field) or a shared helper is the better tool.

**10. VehicleRental example.** Common to all rentals: customer, vehicle ID, number of days, a `calculateRent()` operation. Specific: a `CarRental` charges per day plus insurance; a `TruckRental` charges per day plus a per-kilometre rate and a load surcharge. A base `VehicleRental` holds the shared fields and declares `calculateRent()`, and each subclass overrides it.
