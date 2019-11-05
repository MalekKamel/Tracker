package tracker.common.maps.geocode


class ReverseGeocodeOptimizer(private var results: List<GeocodeResult>) {

    /**
     * Return the longest address
     * @return address
     */
    fun formattedAddress(): String? {
        return results
                .map { item -> item.formatted_address }
                .maxWith(Comparator { item1, item2 -> if (item1!!.length > item2!!.length) 1 else -1 })
    }
}
