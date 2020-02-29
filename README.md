[![Maven Central](https://maven-badges.herokuapp.com/maven-central/dev.ktobe/ktobe/badge.svg)](https://maven-badges.herokuapp.com/maven-central/dev.ktobe/ktobe)
# ktobe
ktobe (pronounced as "_k-TU-bi_") - Kotlin multiplatform post-modern minimalistic YAGNI-driven assertion library.
Heavily influenced by AssertJ.

Current development stage is **alpha**. First more or less stable version expected to be **0.1**

# To install

## Gradle 

```
dependencies {
    testImplementation("dev.ktobe:ktobe:0.0.1")
}
```

## Maven
```
<dependency>
    <groupId>dev.ktobe</groupId>
    <artifactId>ktobe</artifactId>
    <version>0.0.1</version>
    <scope>test</scope>
</dependency>
```

# To use

## Basics

To check referential equality:
```kotlin
const val BATMAN = "Dark Knight"
val bruce = BATMAN

bruce toBe BATMAN       //pass
bruce notToBe BATMAN    //fail
```

To check structural equality:
```kotlin
data class Agent(val name: String, val power: Int)
val agent1 = Agent("smith", 8)
val agent2 = agent1.copy()

agent1 toBeEqual agent2       //pass
agent1 notToBeEqual agent2    //fail
```

Asserts can be chained, everything applied to the first object:
```kotlin
data class Droid(val type: String, val height: Int)
val r2d1 = Droid("Astro", 42)
val r2d2 = r2d1.copy()

r2d2 toBeEqual r2d1 notToBe r2d1    //pass
```

## Collections

tbc

### Collection keywords

tbc