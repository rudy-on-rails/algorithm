class UndergroundSystem {
    data class Trip(
        var startingStation: String,
        var endingStation: String? = null,
        var startTime: Int,
        var endTime: Int? = null
    ) {
        fun tripTime(): Int =
            endTime?.minus(startTime) ?: 0
    }
    private val trips: MutableMap<Int, Trip> = mutableMapOf()
    private val completedTrips = mutableListOf<Trip>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        trips[id] = Trip(stationName, startTime = t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        trips[id]!!.endTime = t
        trips[id]!!.endingStation = stationName
        completedTrips.add(trips[id]!!)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val tripsFromStartingToEndPoint = completedTrips.filter {
            it.startingStation == startStation &&
            it.endingStation == endStation
        }
        val count = tripsFromStartingToEndPoint.size
        return if (count > 0) {
            tripsFromStartingToEndPoint.sumBy { it.tripTime() } / count.toDouble()
        } else {
            0.0
        }
    }
}
