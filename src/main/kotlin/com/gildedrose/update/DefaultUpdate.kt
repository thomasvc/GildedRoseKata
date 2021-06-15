package com.gildedrose.update

import com.gildedrose.DEFAULT_QUALITY_DECREASE
import com.gildedrose.Item
import com.gildedrose.MIN_QUALITY

class DefaultUpdate(private val conjured: Boolean = false) : BaseUpdate() {

    override fun age1Day(item: Item) {
        super.age1Day(item)
        item.updateQuality()
    }

    private fun Item.updateQuality() {
        // Once the sell by date has passed, Quality degrades twice as fast
        var minus = if (sellIn >= 0) DEFAULT_QUALITY_DECREASE else DEFAULT_QUALITY_DECREASE * 2
        // "Conjured" items degrade in Quality twice as fast as normal items
        if (conjured) minus *= 2
        if (quality - minus <= MIN_QUALITY) quality = MIN_QUALITY
        else quality -= minus
    }
}