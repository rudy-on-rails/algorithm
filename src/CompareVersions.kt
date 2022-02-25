import java.lang.Long.parseLong

class CompareVersions {
    data class Version(
        val revisions: MutableList<Long> = mutableListOf()
    ) {
        operator fun compareTo(versionTwo: Version): Int {
            return compareAndFallbackIndex(versionTwo, 0)
        }

        private fun compareAndFallbackIndex(versionTwo: Version, index: Int): Int {
            val currRev = if (index >= revisions.size) {
                0
            } else {
                this.revisions[index]
            }
            val otherRev = if (index >= versionTwo.revisions.size) {
                0
            } else {
                versionTwo.revisions[index]
            }
            return if (currRev.compareTo(otherRev) == 0 && (index < versionTwo.revisions.size || index < this.revisions.size)) {
                compareAndFallbackIndex(versionTwo, index + 1)
            } else {
                currRev.compareTo(otherRev)
            }
        }
    }
    // 1.0.1 x 1.0.2

    fun compareVersion(version1: String, version2: String): Int {
        val versionOne = toVersion(version1)
        val versionTwo = toVersion(version2)
        return versionOne.compareTo(versionTwo)
    }

    private fun toVersion(versionString: String): Version {
        return Version().also { version ->
            versionString.split(".").forEach { s ->
                version.revisions.add(parseLong(s))
            }
        }
    }
}
