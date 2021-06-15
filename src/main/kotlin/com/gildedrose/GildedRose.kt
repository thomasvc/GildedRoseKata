package com.gildedrose

import com.gildedrose.update.*

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach {
            getUpdater(it.name).age1Day(it)
        }
    }

    private val updaters = hashMapOf<String, AgeOneDay>(
            BRIE_NAME to BrieUpdate(),
            SULFURAS_NAME to SulfurasUpdate(),
            BACKSTAGE_PASS_NAME to BackstageUpdate()
    )

    private fun getUpdater(itemName: String): AgeOneDay = updaters.getOrDefault(itemName, DefaultUpdate())
}

