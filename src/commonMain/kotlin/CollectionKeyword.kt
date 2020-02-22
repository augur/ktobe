package dev.ktobe

import dev.ktobe.CollectionKeyword.empty
import dev.ktobe.ToBeAssertError.Companion.toBeEmptyError
import dev.ktobe.ToBeAssertError.Companion.notToBeEmptyError

enum class CollectionKeyword {
    empty
}

infix fun <V, T : Iterable<V>> T.toBe(keyword: CollectionKeyword): T? {
    when (keyword) {
        empty -> if (this.iterator().hasNext()) throw toBeEmptyError()
    }
    return this
}

infix fun <V, T : Iterable<V>> T.notToBe(keyword: CollectionKeyword): T? {
    when (keyword) {
        empty -> if (!this.iterator().hasNext()) throw notToBeEmptyError()
    }
    return this
}