import dev.ktobe.notToBe
import dev.ktobe.notToBeEqual
import dev.ktobe.toBe
import dev.ktobe.toBeEqual
import kotlin.test.Test

internal class BasicTest {

    @Test
    fun `should pass toBe when elements are same`() {
        // Given
        val loupa = "loupa"
        val loupeaux = "loupa"

        // Then
        assertNothingThrown { loupa toBe loupeaux }
    }

    @Test
    fun `should fail toBe when elements are not same`() {
        // Given
        val loupa = "loupa"
        val poupa = "poupa"

        // Then
        assertThrown<AssertionError> { loupa toBe poupa }
    }

    @Test
    fun `should pass notToBe when elements are different`() {
        // Given
        val loupa = "loupa"
        val poupa = "poupa"

        // Then
        assertNothingThrown { loupa notToBe poupa }
    }

    @Test
    fun `should fail notToBe when elements are same`() {
        // Given
        val loupa = "loupa"
        val loupeaux = "loupa"

        // Then
        assertThrown<AssertionError> { loupa notToBe loupeaux }
    }

    @Test
    fun `should pass toBeEqual when elements are equal`() {
        // Given
        val loupa = TestModel("loupa", 42)
        val loupeaux = TestModel("loupa", 42)

        // Then
        assertNothingThrown { loupa toBeEqual loupeaux }
    }

    @Test
    fun `should fail toBeEqual when elements are not equal`() {
        // Given
        val loupa = TestModel("loupa", 42)
        val poupa = TestModel("poupa", 34)

        // Then
        assertThrown<AssertionError> { loupa toBeEqual poupa }
    }

    @Test
    fun `should pass notToBeEqual when elements are not equal`() {
        // Given
        val loupa = TestModel("loupa", 42)
        val poupa = TestModel("poupa", 34)

        // Then
        assertNothingThrown { loupa notToBeEqual poupa }
    }

    @Test
    fun `should fail notToBeEqual when elements are not equal`() {
        // Given
        val loupa = TestModel("loupa", 42)
        val loupeaux = TestModel("loupa", 42)

        // Then
        assertThrown<AssertionError> { loupa notToBeEqual loupeaux }
    }

    data class TestModel(val s: String, val n: Int)
}


