# SOLID Principles: Martin's Classic Examples, Converted to Java

Java translations of the code from all five of Robert C. Martin's original
SOLID essays: **S**ingle Responsibility, **O**pen-Closed, **L**iskov
Substitution, **I**nterface Segregation, and **D**ependency Inversion. Every
package is working, compilable, runnable Java, organized so you can read the
diff between "violates the principle" and "conforms to it," then break
things yourself. A final `solid` package ties all five together in one small
system.

**A bit of history worth knowing:** four of these -- OCP, LSP, DIP, ISP --
were originally Martin's "Engineering Notebook" columns for *C++ Report* in
1996, published in that order and each explicitly referencing the one
before it. SRP is not from that series at all -- it's a later book chapter
(*Agile Software Development: Principles, Patterns, and Practices*),
building on a "cohesion" concept from DeMarco and Page-Jones' earlier
structured-design work. The tidy "SOLID" acronym and S-O-L-I-D ordering
came afterward (commonly credited to Michael Feathers), grouping five
principles from two different sources and a decade apart under one mnemonic.
That's part of why SRP feels a little different in flavor from the other
four -- it's genuinely from a different lineage.

The repo has since grown a second track: the Gang of Four's *Design
Patterns*, implemented the same violating/conforming way and explicitly
tied back to whichever SOLID principle each pattern serves. **Creational**
and **Structural** patterns are both done -- see
[Creational Design Patterns](#creational-design-patterns-gang-of-four) and
[Structural Design Patterns](#structural-design-patterns-gang-of-four)
below. Behavioral patterns are planned next. There's also a standalone
[UML-RELATIONSHIPS.md](UML-RELATIONSHIPS.md) mapping Association,
Aggregation, Composition, Generalization, Realization, and Dependency to
specific, line-referenced code across both tracks.

## How to build and run

```bash
javac -d out $(find src -name "*.java")
java -cp out App
```

Requires JDK 16+ (uses pattern-matching `instanceof`). Tested on JDK 21.

Every `Demo.java` in the project also has its own `main()`, so you can run
any single section standalone instead of the whole 52-part walkthrough:

```bash
java -cp out solid.Demo
java -cp out dip.buttonlamp.conforming.Demo
java -cp out isp.door.violating.Demo
java -cp out creational.abstractfactory.conforming.Demo
java -cp out creational.factory.conforming.Demo
java -cp out structural.bridge.conforming.Demo
```

## Map back to the articles

| Package | Source | Point being made |
|---|---|---|
| `srp.rectangle.violating` / `.conforming` | SRP, Figures 9-1 / 9-2 | `Rectangle.draw()+area()` bundles two reasons to change; split into `GeometricRectangle` (math) and `RectangleRenderer` (drawing). |
| `srp.modem.violating` / `.conforming` | SRP, Listing 9-1 / Figure 9-3 | The fat `Modem` interface bundles connection management with data transfer; split into `Connection` + `DataChannel`, recombined only in the "wart" `ModemImplementation`. |
| `ocp.procedural` | OCP Listing 1 | C-style switch-on-type-tag. Bad in C, still bad (and still common) in Java. |
| `ocp.conforming` | OCP Listing 2 | Abstract `Shape` + polymorphic `draw()`. Adding `Triangle` costs one new file, zero edits elsewhere. |
| `ocp.ordering.violating` | OCP Listings 3-5 | `Circle.precedes()` hard-codes knowledge of `Square`. A new shape means editing *every* existing shape. |
| `ocp.ordering.conforming` | OCP Listing 6 | Ordering policy lives in one isolated `ShapeOrderTable`. Adding `Triangle` costs one file + one line. |
| `ocp.encapsulation` | OCP Listings 7-8 | `Device.status` public = risky. `Time`'s public fields = mostly harmless, because clients are *meant* to write them. |
| `ocp.rtti.violating` / `.conforming` | OCP Listings 9-10 | `instanceof` asking "what are you?" for *every* subtype violates OCP; asking "are you specifically a Square?" does not. |
| `lsp.rtti` | LSP's `DrawShape` example | typeid-based dispatch, reusing OCP's own `Triangle` to show a *known-good* OCP extension defeated by an LSP-violating dispatcher. |
| `lsp.rectangle.violating` / `.conforming` | The Rectangle/Square example | `Square` overrides `setWidth`/`setHeight` to preserve its own invariant, silently breaking a client written under OCP's promise; fixed by making `Square`/`Rectangle` siblings under `Quadrilateral`. |
| `lsp.container.violating` / `.conforming` | The Set/PersistentSet case study | `PersistentSet` implements `Set<T>` but narrows it via an unchecked cast; fixed by making it a sibling `Container`, enforced at compile time instead of runtime. |
| `synthesis` | New -- ties OCP and LSP together | Runs the causal chain end to end: OCP-compliant code, defeated by an LSP violation, restored once LSP holds again. |
| `isp.door.violating` / `.conforming` | The Door/TimedDoor example | `Door` polluted with `TimerClient` forces every derivative (even a `PlainDoor`) to implement timing it doesn't need; fixed by keeping the interfaces separate and multiply-implementing them in `TimedDoor`. |
| `isp.atm.violating` / `.conforming` | The ATM UI example | One fat `UI` interface forces every `Transaction` to depend on prompts it never uses; fixed with segregated `DepositUI`/`WithdrawUI`, including Martin's "polyad vs. monad" argument. |
| `dip.copy.violating` / `.conforming` | The Copy program (Listings 1-4) | `Copy` hard-wired to concrete `KeyboardReader`/`PrinterWriter` (and an if/else "fix" that still violates DIP); fixed by depending on abstract `Reader`/`Writer`. |
| `dip.buttonlamp.violating` / `.conforming` | The Button/Lamp example | `Button` directly coupled to concrete `Lamp`; fixed via the abstract `ButtonClient`, with `Motor` proving reuse and `LampAdapter` handling a third-party class you can't modify. |
| `solid` | New -- all five principles together | A small role-based access-control system where every design decision is traceable to one specific SOLID principle. |

Each package has its own `Demo.java`, called in order from the root
`App.java`, so `java -cp out App` walks through all five articles top to
bottom, ending with the combined system.

## How OCP and LSP interlink

Open-Closed and Liskov Substitution aren't two unrelated rules that happen
to sit next to each other in Martin's column numbering -- LSP is *why* OCP
is safe to rely on.

OCP says: write `ShapeDrawer.drawAllShapes(List<Shape>)` once and never
touch it again, no matter how many new `Shape` subtypes show up later. That
promise only holds if every subtype can genuinely stand in for `Shape`
without the consuming code noticing a difference. LSP is that exact
guarantee, stated as a rule about substitutability rather than about
modification. When LSP breaks, OCP doesn't stay safe just because nobody
edited the "closed" function -- it breaks too, somewhere else, often
somewhere that looks unrelated to the actual mistake:

- **`lsp.rtti`** is the shallow version. It reuses `ocp.conforming.Triangle`
  -- proof that the `Shape` hierarchy really is open for extension -- and
  routes it through an LSP-violating dispatcher instead of the polymorphic
  one. The `Triangle` silently disappears. Nothing was "modified"; the
  dispatcher was simply never built to honor an unfamiliar `Shape` the way
  it honors a familiar one.
- **`lsp.rectangle.violating`** is the sharp version. `g(Rectangle r)` is
  textbook OCP-friendly code: written once against the base type, meant to
  keep working for every derivative forever. It keeps that promise for
  `Rectangle`. It silently breaks for `Square` -- even though `g()` itself
  is never touched -- because `Square` redefines `setWidth`/`setHeight` in a
  way that violates the postcondition `g()` relies on.
- **`lsp.rectangle.conforming`** restores the guarantee: once `Square` stops
  pretending to be a `Rectangle`, `ClientFunctions.area(Quadrilateral)` goes
  back to being reusable, unmodified, for anything that implements the
  interface.
- **`lsp.container.*`** replays the same arc through generics: a `Set<T>`
  client should work for any `Set<T>`; `PersistentSet` violates LSP by
  silently narrowing which `T` it actually accepts, and the client blows up
  at runtime for a `T` it was never warned about.

`synthesis.Demo` runs the shapes through both framings back to back, so the
causal chain is something you can watch happen rather than take on faith.

## How all five principles fit together

The five packages aren't independent exercises -- they're one discipline,
viewed from five angles. The `solid` capstone makes this executable; here's
the reasoning behind it.

**SRP is close to a prerequisite for the rest to even be meaningful.** If a
class has more than one reason to change, "extending" it cleanly (OCP) is
already compromised -- a change driven by reason A can ripple into behavior
that reason B depends on, because they were never actually independent.
Small, cohesive classes are what make a clean extension point possible in
the first place. `srp.rectangle.conforming` separates geometry from
rendering *before* either one needs to vary independently -- that's the
setup OCP later depends on.

**OCP is the goal.** Extend behavior by adding code, not by editing code
that already works.

**LSP is the constraint that makes relying on OCP safe.** Every extension
must be truly substitutable for what it extends, or client code that was
"closed for modification" quietly stops being correct. See the section
above.

**ISP is SRP's argument, applied one level up.** Martin's SRP essay defines
a responsibility as "a reason to change" for a *class*. His ISP essay makes
the identical argument about an *interface*: when two groups of clients use
non-overlapping parts of one interface, that interface has two reasons to
change, and forcing both groups to depend on the whole thing couples them
for no reason. `srp.modem` and `isp.door` are structurally the same fix --
split by client, recombine only where a concrete implementation is
genuinely forced to (`ModemImplementation`, `TimedDoor`) -- discovered from
two different angles a few months apart in Martin's original column series.

**DIP is the mechanism that makes OCP concrete.** "New behavior without
modifying old code" has to be wired up somehow, and DIP is the wiring rule:
the high-level policy (`Copy`, `Button`, `AccessChecker`) depends on an
abstraction (`Reader`/`Writer`, `ButtonClient`, `AccessPolicy`), and every
concrete detail depends on that *same* abstraction. That's what lets a new
`DiskWriter` or a new `ResourceOwnerAccessPolicy` show up later with zero
edits to the policy that uses it -- which is just OCP, achieved through
dependency direction rather than inheritance.

**`solid.Demo` demonstrates all five in one run:** `AccessChecker` has one
job and depends only on abstractions (SRP + DIP); swapping its
`AccessPolicy` requires no changes to `AccessChecker` (OCP); a policy that
violates the "always returns a boolean" contract breaks `AccessChecker`
even though `AccessChecker` was never touched (LSP); and `UserRepository`,
`AccessPolicy`, and `AuditSink` are three separate, thin interfaces instead
of one fat one, so a caller that only needs the policy never has to know
the other two exist (ISP).

## Creational Design Patterns (Gang of Four)

The five *Design Patterns* (Gamma, Helm, Johnson, Vlissides -- "GoF")
Creational patterns, added as a second track alongside the SOLID material
above and cross-referenced against it. Each pattern gets the same
`violating` / `conforming` treatment as the SOLID packages: `violating`
is working code that solves the immediate problem but breaks down under
change, `conforming` is the GoF pattern, and the comments in each file
point at exactly which SOLID principle the pattern is restoring and why.

| Package | Pattern | SOLID tie-in | Point being made |
|---|---|---|---|
| `creational.singleton.violating` / `.conforming` | Singleton | DIP | `.violating`'s `getInstance()` is unsynchronized (racy under concurrent first use) and every caller names the concrete class directly. `.conforming` uses the initialization-on-demand holder idiom (thread-safe, no locking) and returns a `Configuration` interface, so callers -- and tests -- depend on the abstraction, not the Singleton class. |
| `creational.factory.violating` / `.conforming` | Factory | DIP (partial OCP) | `.violating`'s `Demo` has two unrelated methods that each re-implement the same "type string -> concrete `Coin`" decision, so a new coin means finding and fixing every duplicate. `.conforming`'s `CoinFactory` + `CoinType` enum centralizes that decision in one place; callers depend only on `Coin`/`CoinFactory`/`CoinType`, never on `GoldCoin`/`SilverCoin`/`CopperCoin` (DIP) -- but a new coin is still one edit to `CoinType`, not zero. |
| `creational.factorymethod.violating` / `.conforming` | Factory Method | OCP, DIP | `.violating`'s `NotificationService.createNotification()` is an if/else that must be edited for every new channel. `.conforming` moves creation into an overridable `NotificationCreator.createNotification()`; a new channel (`PushNotificationCreator`) is a new file, and the template method `notify()` never changes. |
| `creational.builder.violating` / `.conforming` | Builder | SRP, OCP | `.violating`'s `Computer` telescopes constructor overloads with positional booleans that are easy to transpose. `.conforming` separates assembly (`Computer.Builder`, plus a `StandardBuilds` "Director") from representation (`Computer` itself); every option is named at the call site, and a new optional field is one new method that cannot break an existing caller. |
| `creational.abstractfactory.violating` / `.conforming` | Abstract Factory | OCP, DIP | `.violating`'s `Application` re-checks a theme string and lists every concrete widget class in two separate methods. `.conforming`'s `GUIFactory` produces a matched `Button` + `Checkbox` family per theme; `Application` depends only on `GUIFactory`/`Button`/`Checkbox`, so a new theme is a new factory with zero edits to `Application`. |
| `creational.prototype.violating` / `.conforming` | Prototype | OCP, DIP | `.violating` re-runs the same "expensive setup" at every `new OrcWarrior(...)` call site. `.conforming` registers one pre-built prototype per kind in a `CharacterFactory` and spawns via `copy()` (a deep copy, so clones don't share mutable state) -- the expensive work happens once, and a new kind is one `registerPrototype()` call. |

A few connections worth calling out explicitly:

- **Singleton and DIP pull in opposite directions by default.** The
  pattern's whole point is "exactly one instance, globally reachable" --
  but "globally reachable" usually means "reachable by naming the
  concrete class," which is precisely what DIP says not to do. The
  `.conforming` package resolves the tension the same way `dip.copy` and
  `dip.buttonlamp` do: keep the single instance, but have every consumer
  depend on an interface (`Configuration`) rather than the class that
  implements it.
- **Factory and Factory Method solve the same problem to different
  degrees, and it's worth being precise about the difference.** Factory
  (`creational.factory.conforming`) is *one class* that decides which
  concrete type to build, based on a parameter -- here, a `CoinType`
  enum mapping to constructors. That's a real DIP win over `.violating`
  (callers stop depending on `GoldCoin`/`SilverCoin`/`CopperCoin`) and a
  real DRY win (the decision exists exactly once instead of once per call
  site), but it is *not* a full OCP win: a new `PlatinumCoin` still means
  editing `CoinType`. Factory Method
  (`creational.factorymethod.conforming`) removes that last edit by
  moving the decision into a class hierarchy instead of a single method --
  a new channel is a new `NotificationCreator` subclass, and nothing
  that already compiles gets touched. Factory is "GoF-adjacent" (not one
  of the original 23 patterns); Factory Method is.
- **Factory Method is OCP's Open half, made about object creation
  specifically.** `ocp.conforming.Shape` already showed "closed for
  modification" for *behavior*; `NotificationCreator` shows the identical
  shape for *construction* -- a new product arrives as a new subclass,
  never as an edit to code that already works.
- **Builder is SRP applied to construction itself.** A class that both
  represents a fully-built object *and* handles every combination of
  how it might be partially built has two reasons to change: its data
  model, and its assembly rules. Splitting those (`Computer` /
  `Computer.Builder`) is the same move `srp.rectangle.conforming` makes
  splitting geometry from rendering.
- **Abstract Factory is DIP at the level of a whole product family.**
  Plain Factory Method abstracts "how do I create one thing"; Abstract
  Factory abstracts "how do I create a consistent *set* of things,"
  which is what keeps `LightThemeFactory` from ever being able to hand
  back a mismatched `DarkCheckbox`.
- **Prototype is a DIP-flavored alternative to Factory Method /
  Abstract Factory**, useful specifically when construction is expensive
  or when the exact concrete class to instantiate isn't known until
  runtime. Clients still depend on an abstraction (`GameCharacter`), but
  the "factory" (`CharacterFactory`) hands out copies of live objects
  instead of running a constructor.

**Source:** implementations here are original, written for this repo to
demonstrate each pattern's mechanics and its link back to SOLID -- they
are not transcriptions of any particular book's listings. For the
canonical GoF description and further worked examples of each pattern,
see the [Java Design Patterns](https://java-design-patterns.com/patterns/#read-online)
reference site: [Singleton](https://java-design-patterns.com/patterns/singleton/),
[Factory](https://java-design-patterns.com/patterns/factory/),
[Factory Method](https://java-design-patterns.com/patterns/factory-method/),
[Builder](https://java-design-patterns.com/patterns/builder/),
[Abstract Factory](https://java-design-patterns.com/patterns/abstract-factory/),
and [Prototype](https://java-design-patterns.com/patterns/prototype/).

## Structural Design Patterns (Gang of Four)

The second GoF category, same treatment as Creational: `violating` /
`conforming` pairs, each comment pointing at the SOLID principle the
pattern restores. Structural patterns are specifically about how classes
and objects are *composed* into larger structures, which makes them the
natural place to see UML relationship types in concrete code -- see
[UML-RELATIONSHIPS.md](UML-RELATIONSHIPS.md) for exactly how each pattern
below decomposes into Aggregation/Composition/Generalization/Realization.

| Package | Pattern | SOLID tie-in | Point being made |
|---|---|---|---|
| `structural.adapter.violating` / `.conforming` | Adapter | OCP, DIP | `.violating`'s `Captain` special-cases `FishingBoat` with an `instanceof` branch because it has an incompatible interface. `.conforming`'s `FishingBoatAdapter implements RowingBoat` and translates `row()` into `sail()`; `Captain` depends on `RowingBoat` only, and a new incompatible boat type is a new adapter, not a new branch. |
| `structural.decorator.violating` / `.conforming` | Decorator | OCP | `.violating` hardcodes each topping combination as its own subclass (`CoffeeWithMilk`, `CoffeeWithMilkAndSugar`, ...) -- combinatorial growth. `.conforming`'s `CoffeeDecorator` wraps a `Coffee` instead of extending one; toppings stack at runtime (`new SugarDecorator(new MilkDecorator(...))`), and a new topping is one new decorator class, not one new class per combination it can appear in. |
| `structural.facade.violating` / `.conforming` | Facade | DIP (and DRY) | `.violating`'s `Demo` has two methods that each duplicate the same `CPU`/`Memory`/`HardDrive` boot sequence, depending on all three concretely. `.conforming`'s `ComputerFacade` owns that orchestration in one place; client code depends on the facade only, and `startInSafeMode()` reuses `start()` instead of re-deriving the sequence. |
| `structural.composite.violating` / `.conforming` | Composite | OCP, DIP | `.violating`'s `Directory` splits children into two separate lists, forcing `Demo.totalSizeKb()` to recurse by hand and know both types. `.conforming`'s `FileSystemComponent` interface lets `File` and `Directory` answer `getSizeKb()` identically; `Directory.getSizeKb()` recurses internally, so a client just calls `root.getSizeKb()` and the tree structure is invisible to it. |
| `structural.proxy.violating` / `.conforming` | Proxy | DIP | `.violating` constructs every `RealImage` up front, paying the "load from disk" cost whether or not it's ever displayed. `.conforming`'s `ProxyImage implements Image` and builds the real one lazily on first `display()`; callers depend on `Image` and can't tell a proxy from the real thing. |
| `structural.bridge.violating` / `.conforming` | Bridge | OCP, DIP | `.violating` welds shape and color together (`RedCircle`, `BlueSquare`, ...) -- N shapes x M colors means N*M classes. `.conforming`'s `Shape` holds a `Color` instead of extending one; a new color is one class, immediately usable by every existing shape (N+M classes instead of N*M). |
| `structural.flyweight.violating` / `.conforming` | Flyweight | DIP (and memory efficiency) | `.violating`'s `Tree` copies its own name/color/texture into every instance, even when many trees share an identical species. `.conforming`'s `TreeFactory` caches one shared `TreeType` per species; `Tree` stores only its own position and a reference to the shared type -- the same registry shape as `creational.prototype.conforming.CharacterFactory`, but sharing instead of cloning. |

A few connections worth calling out explicitly:

- **Adapter and Bridge both use a wrapped/held interface to restore DIP,
  but for different reasons.** Adapter exists because two interfaces
  already exist and don't match -- it's a retrofit. Bridge exists because
  you're designing from scratch and want to *prevent* a combinatorial
  explosion before it happens. If `structural.bridge.violating` already
  shipped and you needed to plug in a third-party `Color` implementation
  with an incompatible interface, you'd reach for Adapter *inside* the
  Bridge design -- the two patterns compose.
- **Decorator vs. Bridge vs. Composite is a good "when do I hold another
  object instead of extending it" comparison**, since all three replace
  inheritance with composition for a different reason: Decorator adds
  *behavior* incrementally (any number of wraps, same interface in and
  out); Bridge separates *two independently-varying dimensions*
  (abstraction vs. implementor); Composite represents a *whole-part tree*
  where the container and the leaf must answer identically.
- **Facade is the one Structural pattern that isn't primarily about
  swapping implementations.** `ComputerFacade` doesn't make `CPU` easier
  to replace -- it makes the *boot sequence* have exactly one owner. It's
  DIP applied to a call site's knowledge of orchestration order, not to
  its knowledge of a type.
- **Proxy and the Singleton's holder idiom solve adjacent problems with
  the same tool: lazy, controlled construction behind an unchanged
  interface.** `creational.singleton.conforming.ConfigurationManager`
  defers work until first `getInstance()` call and then reuses one
  instance forever; `structural.proxy.conforming.ProxyImage` defers work
  until first `display()` call, per-instance. Same idea, different scope.
- **Flyweight is Prototype's mirror image.** Both center on a factory
  that caches something expensive to avoid rebuilding it
  (`creational.prototype.conforming.CharacterFactory` and
  `structural.flyweight.conforming.TreeFactory` are nearly the same
  shape). Prototype hands back an independent *copy* so callers can
  safely mutate their own; Flyweight hands back the *same shared
  instance* so many callers can reference it without duplicating memory --
  which only works because the shared part (`TreeType`) is treated as
  immutable.

**Source:** implementations here are original, written for this repo. For
the canonical GoF description and further worked examples, see
[Adapter](https://java-design-patterns.com/patterns/adapter/),
[Decorator](https://java-design-patterns.com/patterns/decorator/),
[Facade](https://java-design-patterns.com/patterns/facade/),
[Composite](https://java-design-patterns.com/patterns/composite/),
[Proxy](https://java-design-patterns.com/patterns/proxy/),
[Bridge](https://java-design-patterns.com/patterns/bridge/), and
[Flyweight](https://java-design-patterns.com/patterns/flyweight/) on
[Java Design Patterns](https://java-design-patterns.com/patterns/#read-online).

## Java vs. C++ notes

- **No `friend`:** `ocp.rtti.violating` uses package-private
  fields/constructors as the nearest equivalent.
- **No raw structs / free functions:** `ocp.procedural` uses a `ShapeType`
  enum + a marker interface instead of a shared first struct member;
  `dip.copy.*` turns C's free functions (`ReadKeyboard`, `getchar`) into
  small classes with a `read()`/`write()` method.
- **`dynamic_cast<T*>` -> `instanceof T t`** (Java 16+ pattern matching) --
  used for a subtype check in `ocp.rtti.*`.
- **`typeid(s) == typeid(Square)` -> `s.getClass() == Square.class`** --
  used in `lsp.rtti`. This is an *exact*-type check, stricter than
  `instanceof`: it also rejects subclasses of `Square`, not just
  non-Squares.
- **`dynamic_cast<PersistentObject&>(t)` throwing `bad_cast` -> an explicit
  Java cast throwing `ClassCastException`** -- used in
  `lsp.container.violating`.
- **C++ templates -> Java generics**, with one extra wrinkle: Java's type
  erasure is *why* `PersistentSet<T>.add()` is allowed to compile an unsafe
  cast at all.
- **C++ multiple inheritance -> Java multiple interface implementation.**
  This is the single biggest simplification in the whole project. Martin's
  ISP article treats "class form of Adapter via multiple inheritance" as
  his *preferred* solution but a nontrivial one in C++. In Java,
  `isp.door.conforming.TimedDoor implements Door, TimerClient` is just...
  normal. No adapter, no inheritance diamond to reason about, because
  interfaces carry no state. The delegation form (`DoorTimerAdapter`) is
  kept in the project for comparison, but Java rarely needs it for this
  specific problem shape.
- **`operator+=`/`operator-=` -> `Time.plusSeconds()`/`minusSeconds()`,**
  kept mutating + chainable (`return this`) to match the original C++
  semantics.

## Exercises

1. **Break `ocp.ordering.violating` on purpose.** Add a `Triangle`. Count
   how many files you had to touch. Do the same in `ocp.ordering.conforming`
   and confirm only `ShapeOrderTable` changes.
2. **Find a real switch-on-type in your own codebase** and refactor it the
   way `ocp.procedural` -> `ocp.conforming` did here.
3. **Argue with Martin.** He calls `Time`'s public fields defensible.
   Rewrite `ocp.encapsulation.Time` with private fields and a 3-arg
   `setTime(h, m, s)` and decide if it's actually better, or just more
   ceremony.
4. **LSP check on your own extensions.** Add a `Shape` whose `draw()` needs
   extra setup the others don't and see where the abstraction starts to
   strain.
5. **RBAC warm-up, done properly.** You already saw this idea sketched as
   an exercise -- now it's `solid`. Add a third `AccessPolicy` (e.g.
   time-of-day restrictions) without touching `AccessChecker`, then add a
   fourth interface (`RateLimiter`) to the system and decide whether it
   belongs bundled into `AccessPolicy` or kept separate. Defend the answer
   in ISP terms.
6. **Reproduce the "far away" bug.** Call `dip.copy.violating.Copy` from a
   method two or three layers removed from `Demo.run()`. Notice how much
   further from the real mistake (the hard-coded dependency) the eventual
   change request lands.
7. **Design by Contract, made explicit.** Add pre/postcondition comments to
   `lsp.rectangle.violating.Rectangle.setWidth`/`setHeight`, then to
   `Square`'s overrides, and write out exactly which postcondition `Square`
   weakens.
8. **Find the SRP/ISP pair yourself.** Before reading the mapping table
   above, look at `srp.modem.conforming` and `isp.door.conforming` side by
   side and write down, in your own words, why they're the same fix.
9. **Extend the capstone's LSP break.** `FlakyAccessPolicy` throws for an
   unrecognized role. Write a *second* kind of LSP-violating policy --
   for instance, one that returns `true` non-deterministically -- and add
   an eval-style test in `Demo` that would have caught it before it shipped.
10. **Run the synthesis backwards.** Starting from `lsp.container.conforming`
    (already LSP-compliant), write a *new* client function that would break
    if `PersistentSet` were changed back to implementing `Set<T>` directly --
    predict the bug before you reintroduce it.

## Source

Robert C. Martin: "The Open-Closed Principle," "The Liskov Substitution
Principle," "The Dependency Inversion Principle," and "The Interface
Segregation Principle" (Engineering Notebook columns, *C++ Report*, 1996);
and the Single Responsibility Principle chapter of *Agile Software
Development: Principles, Patterns, and Practices*. Code re-expressed in
Java for practice; `lsp.rectangle.conforming` and the entire `solid`
package are original extensions built to demonstrate the principles rather
than listings transcribed from the articles. The original article text and
C++ listings are Martin's.
