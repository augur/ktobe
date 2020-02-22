package dev.ktobe

class ToBeAssertError(override val message: String?): AssertionError(message) {

    companion object {
        internal fun <T>T?.toBeError(expected: T?) = assertError(expected, "to be")
        internal fun <T>T?.notToBeError(expected: T?) = assertError(expected, "not to be")
        internal fun <T>T?.toBeEqualError(expected: T?) = assertError(expected, "to be equal")
        internal fun <T>T?.notToBeEqualError(expected: T?) = assertError(expected, "not to be equal")

        internal fun <V, T : Collection<V>>T.toContainExactlyError(expected: T) = assertError(expected, "to contain exactly")
        internal fun <V, T : Collection<V>>T.toContainOnlyError(expected: T) = assertError(expected, "to contain only")
        internal fun <V, T : Iterable<V>>T.toContainJustError(expected: V) = assertError(expected, "to contain just")

        private fun Any?.assertError(expected: Any?, relation: String) = ToBeAssertError("$this had $relation $expected")
    }
}