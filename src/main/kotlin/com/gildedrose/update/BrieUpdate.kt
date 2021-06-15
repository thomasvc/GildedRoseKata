package com.gildedrose.update

import com.gildedrose.DEFAULT_QUALITY_INCREASE
import com.gildedrose.Item
import com.gildedrose.MAX_QUALITY

class BrieUpdate : BaseUpdate() {

    /** "Aged Brie" actually increases in Quality the older it gets */

    override fun age1Day(item: Item) {
        super.age1Day(item)
        item.updateQuality()
    }

    private fun Item.updateQuality() {
        val plus = if (sellIn >= 0) DEFAULT_QUALITY_INCREASE else DEFAULT_QUALITY_INCREASE * 2
        if(quality + plus >= MAX_QUALITY) quality = MAX_QUALITY
        else quality += plus
    }
}