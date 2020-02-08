package dev.ktobe


infix fun <T> T?.toBe(other: T?): T? {
    if (other !== this) throw AssertionError()
    return this
}

infix fun <T> T?.notToBe(other: T?): T? {
    if (other === this) throw AssertionError()
    return this
}

infix fun <T> T?.toBeEqual(other: T?): T? {
    if (other != this) throw AssertionError()
    return this
}

infix fun <T> T?.notToBeEqual(other: T?): T? {
    if (other == this) throw AssertionError()
    return this
}