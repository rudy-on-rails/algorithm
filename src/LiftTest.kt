import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LiftTest {
    private val lift = Lift()
    @Test
    fun `callLift - only one time, should arrive at destination floor`() {
        lift.callLift(5)
        assertEquals(5, lift.nextFloor())
    }

    @Test
    fun `callLift - twice, should arrive at nearest floor first`() {
        lift.callLift(5)
        lift.callLift(8)
        assertEquals(5, lift.nextFloor())
        assertEquals(8, lift.nextFloor())
    }

    @Test
    fun `callLift - three times, should arrive at each floor in order`() {
        lift.callLift(8)
        lift.callLift(5)
        lift.callLift(6)
        assertEquals(5, lift.nextFloor())
        assertEquals(6, lift.nextFloor())
        assertEquals(8, lift.nextFloor())
    }

    @Test
    fun `callLift - bazinga`() {
        lift.callLift(8)
        lift.callLift(5)
        lift.callLift(6)
        lift.callLift(9)
        lift.callLift(1)
        assertEquals(1, lift.nextFloor())
        assertEquals(5, lift.nextFloor())
        assertEquals(6, lift.nextFloor())
        assertEquals(8, lift.nextFloor())
        assertEquals(9, lift.nextFloor())
    }
}
