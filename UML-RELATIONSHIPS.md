# UML Relationships in This Codebase

Six kinds of relationship show up between classes and objects in this
repo: **Association**, **Aggregation**, **Composition**, **Generalization**,
**Realization**, and **Dependency**. This doc maps each one to real,
line-referenced code -- some from the original SOLID track, some new from
the [Structural Design Patterns](README.md#structural-design-patterns-gang-of-four).

One historical note before the table: Robert Martin's original DIP article
(the source for `dip.*`) is C++, and C++ draws Aggregation ("contains --
by reference," a raw pointer member like `Lamp* itsLamp;`) and Composition
("contains -- by value," `B itsB;`) as a genuine syntactic choice, because
C++ objects really can be embedded by value. It also has no separate
`implements` keyword -- both inheriting from a concrete base class and
inheriting from a pure-abstract one use the identical `class X : public Y`
syntax, so **Generalization and Realization render as the exact same
notation** in a diagram drawn from that article. Modern UML (and this
table) tells them apart: solid line + hollow triangle for Generalization
(`extends`), dashed line + hollow triangle for Realization (`implements`).
Java doesn't have C++'s by-value members at all -- every field is a
reference -- so the Aggregation/Composition split here is about
**ownership**, not memory layout: does the container create and exclusively
own the thing (Composition), or just hold a reference to something that
exists independently (Aggregation)?

## Association

The umbrella term UML uses for "one class holds a reference to another."
Aggregation and Composition below are both *kinds* of Association --
distinguished by ownership strength. Nothing in this repo needs a bare,
unqualified Association example for the same reason the source article
never uses one either: every real relationship here is specific enough to
classify as one of the two cases below.

## Aggregation

**Contains, by reference, independent lifetimes** (hollow diamond). The
container holds a reference to an object that was created elsewhere, is
passed in, and would go on existing even if the container didn't.

- [`dip/buttonlamp/violating/Button.java:9`](src/dip/buttonlamp/violating/Button.java#L9)
  -- `private final Lamp lamp;`, populated via the constructor
  ([line 12](src/dip/buttonlamp/violating/Button.java#L12)). This is the
  direct Java translation of Martin's C++ `Lamp* itsLamp;` -- Button
  doesn't build the Lamp, just holds onto one handed to it.
- [`structural/bridge/conforming/Shape.java`](src/structural/bridge/conforming/Shape.java)
  -- `protected final Color color;`, injected through the constructor. A
  `Red` or `Blue` instance isn't owned by any one `Shape`; the same
  instance could be handed to a `Circle` and a `Square` alike.
- [`structural/flyweight/conforming/Tree.java`](src/structural/flyweight/conforming/Tree.java)
  -- `private final TreeType type;`. The `TreeType` is owned by
  `TreeFactory`'s cache, not by any individual `Tree`; many `Tree`s
  reference the exact same `TreeType` instance.

## Composition

**Contains, by value, exclusive ownership** (filled diamond). The
container creates the object itself, and it has no life or meaning
outside the container. As flagged before: DIP's own `dip.*` packages
never actually show this, because every field there is deliberately kept
abstract (`Reader`, `Writer`, `ButtonClient`) -- that's the whole point of
DIP. The Structural patterns, being about assembling concrete subsystems,
finally give this repo real examples:

- [`structural/facade/conforming/ComputerFacade.java`](src/structural/facade/conforming/ComputerFacade.java)
  -- `private final CPU cpu = new CPU();` (and `memory`, `hardDrive`
  alongside it). All three are created inline, right there, and nothing
  outside `ComputerFacade` ever sees or shares them.
- [`structural/flyweight/conforming/Forest.java`](src/structural/flyweight/conforming/Forest.java)
  -- `private final TreeFactory treeFactory = new TreeFactory();`. Compare
  this to the same file's `List<Tree> trees` holding onto shared
  `TreeType`s by Aggregation two paragraphs up -- one file, both
  relationship strengths, side by side.
- [`structural/proxy/conforming/ProxyImage.java`](src/structural/proxy/conforming/ProxyImage.java)
  -- `private RealImage realImage;`, built with `new RealImage(fileName)`
  the first time `display()` runs. The proxy owns it outright; nothing
  else ever gets a reference to that specific `RealImage`.

## Generalization

**Inheritance between two classes** (`extends`) -- solid line, hollow
triangle.

- [`lsp/rectangle/violating/Square.java:8`](src/lsp/rectangle/violating/Square.java#L8)
  -- `public class Square extends Rectangle`. The repo's original example,
  and also the one that shows Generalization can be *used correctly*
  syntactically while still violating LSP semantically -- the two concerns
  are independent.
- [`structural/bridge/conforming/Circle.java`](src/structural/bridge/conforming/Circle.java)
  -- `public class Circle extends Shape`, alongside `Square extends Shape`
  in the same package: two siblings under one abstraction, the shape
  Generalization is meant to produce.
- [`structural/decorator/violating/CoffeeWithMilk.java`](src/structural/decorator/violating/CoffeeWithMilk.java)
  -- `extends SimpleCoffee`, then `CoffeeWithMilkAndSugar extends
  CoffeeWithMilk`: a Generalization *chain*, and exactly the chain that
  turns into a combinatorial explosion, which is why `.conforming` replaces
  it with Aggregation instead (`CoffeeDecorator` holds a `Coffee`, rather
  than extending one).

## Realization

**Inheritance from a class to an interface** (`implements`) -- dashed
line, hollow triangle. Same arrowhead as Generalization, different line
style; this is the distinction the source C++ article's own notation
can't make, since C++ has no `implements` keyword separate from
`extends`.

- [`isp/door/conforming/TimedDoor.java:9`](src/isp/door/conforming/TimedDoor.java#L9)
  -- `public class TimedDoor implements Door, TimerClient`. The repo's
  original example, and a Java-only trick: implementing two interfaces at
  once needs no adapter machinery, where Martin's C++ needed multiple
  inheritance to get the same effect.
- [`structural/adapter/conforming/FishingBoatAdapter.java`](src/structural/adapter/conforming/FishingBoatAdapter.java)
  -- `implements RowingBoat`. This is Realization used for its most
  classic purpose: satisfying a target interface by wrapping something
  that doesn't natively have the right shape.
- [`structural/bridge/conforming/Red.java`](src/structural/bridge/conforming/Red.java) /
  [`Blue.java`](src/structural/bridge/conforming/Blue.java) -- both
  `implements Color`. Paired with `Shape`'s Aggregation of `Color` above,
  this is the two relationships Bridge is built from: Realization on the
  implementor side, Aggregation on the abstraction side.

## Dependency

**"Uses," transiently** -- invoking a member function, or a type that
shows up only as a parameter/return/local variable, never stored as a
field. The weakest relationship, drawn as a dashed arrow with an open
head (no diamond, because nothing is "contained").

- [`dip/copy/conforming/Copy.java:9-14`](src/dip/copy/conforming/Copy.java#L9-L14)
  -- `copy(Reader r, Writer w)` calls `r.read()` and `w.write(...)`.
  `Copy` is a static method with no fields at all; `Reader`/`Writer` exist
  in its world only for the duration of one call. This is the repo's
  original example, and it's worth noticing it's a Dependency on an
  *abstraction* -- which is exactly what makes it DIP-compliant.
- [`dip/copy/violating/Copy.java:20-32`](src/dip/copy/violating/Copy.java#L20-L32)
  -- the contrast: `copyEnhanced(OutputDevice device)` is *also* just a
  Dependency (a parameter, used and discarded), but this time on top of
  local variables like `KeyboardReader reader = new KeyboardReader();`
  that depend on concrete classes. Same relationship *kind* as the
  conforming version -- Dependency is Dependency whether the thing
  depended on is abstract or concrete -- but a much worse relationship
  *target*. That distinction (kind vs. target) is the real lesson DIP is
  teaching.

## Which relationships each Structural pattern is built from

A pattern is really just a name for a small, specific arrangement of
these six relationship types. Once you can see the arrangement, the
pattern stops being something to memorize:

| Pattern | Relationships |
|---|---|
| Adapter | **Realization** (`FishingBoatAdapter implements RowingBoat`) + **Composition** (the adapter creates/owns nothing here, but in the general case wraps an Adaptee it's handed -- Aggregation if injected, Composition if it constructs its own) |
| Decorator | **Realization** (`CoffeeDecorator implements Coffee`) + **Aggregation** (`CoffeeDecorator` holds the wrapped `Coffee` it was given) |
| Facade | **Composition** (`ComputerFacade` owns `CPU`/`Memory`/`HardDrive` outright) + **Dependency** (client code calls the facade's methods without storing a reference to its subsystems) |
| Composite | **Realization** (`File`/`Directory implements FileSystemComponent`) + **Aggregation**, recursively (`Directory` holds a list of `FileSystemComponent`, which may themselves be `Directory`s) |
| Proxy | **Realization** (`ProxyImage implements Image`) + **Composition** (the proxy creates and owns its own `RealImage`) |
| Bridge | **Aggregation** (`Shape` holds a `Color`) + **Generalization** (`Circle`/`Square extends Shape`) + **Realization** (`Red`/`Blue implements Color`) |
| Flyweight | **Aggregation** (`Tree` references a shared `TreeType` it doesn't own) + **Composition** (`Forest` owns its own `TreeFactory`) |
