package dev.ktobe

import dev.ktobe.ToBeAssertError.Companion.notToBeError
import dev.ktobe.ToBeAssertError.Companion.toBeError
import dev.ktobe.ToBeAssertError.Companion.toBeEqualError
import dev.ktobe.ToBeAssertError.Companion.notToBeEqualError

infix fun <T> T?.toBe(other: T?): T? {
    if (other !== this) throw toBeError(other)
    return this
}

infix fun <T> T?.notToBe(other: T?): T? {
    if (other === this) throw notToBeError(other)
    return this
}

infix fun <T> T?.toBeEqual(other: T?): T? {
    if (other != this) throw toBeEqualError(other)
    return this
}

infix fun <T> T?.notToBeEqual(other: T?): T? {
    if (other == this) throw notToBeEqualError(other)
    return this
}