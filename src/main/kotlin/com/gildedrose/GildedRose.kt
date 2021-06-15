package com.gildedrose

import com.gildedrose.update.AgeOneDay
import com.gildedrose.update.DefaultUpdate

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach {
            getUpdater(it.name).age1Day(it)
        }
    }

    private fun getUpdater(itemName: String): AgeOneDay {
        return if (itemName.toLowerCase().startsWith(CONJURED_LOWERCASE)) DefaultUpdate(true)
        else updaters.getOrDefault(itemName, DefaultUpdate())
    }
}

