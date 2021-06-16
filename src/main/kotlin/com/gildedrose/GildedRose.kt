package com.gildedrose

import com.gildedrose.update.UpdateOneDay
import com.gildedrose.update.DefaultUpdate

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach {
            getUpdater(it.name).update1Day(it)
        }
    }

    private fun getUpdater(itemName: String): UpdateOneDay {
        return if (itemName.toLowerCase().startsWith(CONJURED_LOWERCASE)) DefaultUpdate(true)
        else updaters.getOrDefault(itemName, DefaultUpdate())
    }
}

