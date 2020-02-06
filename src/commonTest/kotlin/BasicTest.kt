import dev.ktobe.toBe
import kotlin.test.Test


internal class BasicTest {

    @Test
    fun `should match toBe when elements are same`() {
        // Given
        val bob = "Bob Dylan"
        val dylan = "Bob Dylan"

        // Then
        assertNothingThrown { bob toBe dylan }
    }


    private fun assertNothingThrown(block: () -> Unit) = block.invoke()
}

