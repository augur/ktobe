
fun assertNothingThrown(block: () -> Unit) = block.invoke()

inline fun <reified T : Throwable>assertThrown(block: () -> Unit) {
    try {
        block.invoke()
    } catch (e: Throwable) {
        if (e !is T) {
            throw e
        }
        return
    }
    throw AssertionError("Nothing was thrown")
}