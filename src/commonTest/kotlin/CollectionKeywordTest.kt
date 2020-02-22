import dev.ktobe.CollectionKeyword.empty
import dev.ktobe.ToBeAssertError
import dev.ktobe.notToBe
import dev.ktobe.toBe
import kotlin.test.Test

internal class CollectionKeywordTest {

    @Test
    fun `should pass toBe empty when iterable is empty`() {
        // Given
        val users = emptyList<Int>()

        // Then
        assertNothingThrown { users toBe empty }
    }

    @Test
    fun `should fail toBe empty when iterable is not empty`() {
        // Given
        val users = listOf(42)

        // Then
        assertThrown<ToBeAssertError> { users toBe empty }
    }

    @Test
    fun `should pass notToBe empty when iterable is not empty`() {
        // Given
        val users = listOf(42)

        // Then
        assertNothingThrown { users notToBe empty }
    }

    @Test
    fun `should fail notToBe empty when iterable is empty`() {
        // Given
        val users = emptyList<Int>()

        // Then
        assertThrown<ToBeAssertError> { users notToBe empty }
    }
}