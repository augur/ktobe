package dev.ktobe


infix fun <T> T?.toBe(other: T?): T? {
    if (other !== this) throw AssertionError()
    return this
}