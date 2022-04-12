class MyHashMap {
    private val keys = mutableSetOf<Int>()
    private val values = arrayListOf<Int>()

    fun put(key: Int, value: Int) {
        remove(key)
        keys.add(key)
        val index = keys.indexOf(key)
        values.add(index, value)
    }

    fun get(key: Int): Int {
        val index = keys.indexOf(key)
        return if (index != -1) {
            values.elementAt(index)
        } else {
            -1
        }
    }

    fun remove(key: Int) {
        val index = keys.indexOf(key)
        if (index != -1) {
            keys.remove(key)
            values.removeAt(index)
        }
    }

    override fun toString(): String {
        return this.keys.toString().plus(this.values.toString())
    }

}
