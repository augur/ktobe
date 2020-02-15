package dev.ktobe

infix fun <V, T : Collection<V>> T.toContainExactly(other: T): T {
    if (this.size != other.size) throw AssertionError()
    val thisIterator = this.iterator()
    val otherIterator = other.iterator()
    while (thisIterator.hasNext()) {
        if (thisIterator.next() != otherIterator.next()) throw AssertionError()
    }
    return this
}

infix fun <V, T : Set<V>> T.toContainOnly(other: T): T {
    if (this.size != other.size) throw AssertionError()
    if (this.size != (this intersect other).size) throw AssertionError()
    return this
}

infix fun <V, T : Iterable<V>> T.toContainJust(other: V): T {
    val iter = this.iterator()
    if (!iter.hasNext()) throw AssertionError()
    if (iter.next() != other) throw AssertionError()
    if (iter.hasNext()) throw AssertionError()
    return this
}
