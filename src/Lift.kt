class Lift {
    private var destinationFloors = mutableListOf<Int>()
    fun callLift(floorNumber: Int) {
        destinationFloors.add(floorNumber)
        destinationFloors.sort()
    }

    fun nextFloor(): Int? {
        return destinationFloors.removeAt(0)
    }
}
