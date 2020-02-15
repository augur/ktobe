import dev.ktobe.toContainExactly
import dev.ktobe.toContainJust
import dev.ktobe.toContainOnly
import kotlin.test.Test

internal class CollectionsTest {

    @Test
    fun `should pass toContainExactly when collections are equal`() {
        // Given
        val users = listOf("loupa", "poupa")

        // Then
        assertNothingThrown { users toContainExactly listOf("loupa", "poupa") }
    }

    @Test
    fun `should fail toContainExactly when collections have different size`() {
        // Given
        val users = listOf("loupa", "poupa")

        // Then
        assertThrown<AssertionError> { users toContainExactly listOf("loupa") }
    }

    @Test
    fun `should fail toContainExactly when collections have different order`() {
        // Given
        val users = listOf("loupa", "poupa")

        // Then
        assertThrown<AssertionError> { users toContainExactly listOf("poupa", "loupa") }
    }

    @Test
    fun `should pass toContainOnly when sets are equal regardless order`() {
        // Given
        val users = setOf("loupa", "poupa")

        // Then
        assertNothingThrown { users toContainOnly setOf("poupa", "loupa") }
    }

    @Test
    fun `should fail toContainOnly when sets have different size`() {
        // Given
        val users = setOf("loupa", "poupa")

        // Then
        assertThrown<AssertionError> { users toContainOnly setOf("loupa") }
    }

    @Test
    fun `should fail toContainOnly when sets have different content`() {
        // Given
        val users = setOf("poupa")

        // Then
        assertThrown<AssertionError> { users toContainOnly setOf("loupa") }
    }

    @Test
    fun `should pass toContainJust when iterable has just a matching element`() {
        // Given
        val users = setOf("loupa")

        // Then
        assertNothingThrown { users toContainJust "loupa" }
    }

    @Test
    fun `should fail toContainJust when iterable is empty`() {
        // Given
        val users = emptyList<String>()

        // Then
        assertThrown<AssertionError> { users toContainJust "loupa" }
    }

    @Test
    fun `should fail toContainJust when iterable has another element`() {
        // Given
        val users = listOf("poupa")

        // Then
        assertThrown<AssertionError> { users toContainJust "loupa" }
    }

    @Test
    fun `should fail toContainJust when iterable has more than single element`() {
        // Given
        val users = listOf("loupa", "poupa")

        // Then
        assertThrown<AssertionError> { users toContainJust "loupa" }
    }
}