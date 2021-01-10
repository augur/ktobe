package dev.ktobe

import dev.ktobe.ToBeAssertError.Companion.toContainExactlyError
import dev.ktobe.ToBeAssertError.Companion.toContainOnlyError
import dev.ktobe.ToBeAssertError.Companion.toContainJustError
import dev.ktobe.ToBeAssertError.Companion.toContainError
import dev.ktobe.ToBeAssertError.Companion.notToContainError

infix fun <V, T : Collection<V>> T.toContainExactly(other: T): T {
    if (this.size != other.size) throw toContainExactlyError(other)
    val thisIterator = this.iterator()
    val otherIterator = other.iterator()
    while (thisIterator.hasNext()) {
        if (thisIterator.next() != otherIterator.next()) throw toContainExactlyError(other)
    }
    return this
}

//TODO for all Iterables
infix fun <V, T : Set<V>> T.toContainOnly(other: T): T {
    if (this.size != other.size) throw toContainOnlyError(other)
    if (this.size != (this intersect other).size) throw toContainOnlyError(other)
    return this
}

infix fun <V, T : Iterable<V>> T.toContainJust(other: V): T {
    val iter = this.iterator()
    if (!iter.hasNext()) throw toContainJustError(other)
    if (iter.next() != other) throw toContainJustError(other)
    if (iter.hasNext()) throw toContainJustError(other)
    return this
}

infix fun <V, T : Iterable<V>> T.toContain(other: V): T {
    if (!this.contains(other)) throw toContainError(other)
    return this
}

infix fun <V, T : Iterable<V>> T.notToContain(other: V): T {
    if (this.contains(other)) throw notToContainError(other)
    return this
}

//TODO toContainAll
