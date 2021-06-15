package com.gildedrose.update

import com.gildedrose.Item

class DefaultUpdate : BaseUpdate() {

    override fun age1Day(item: Item) {
        super.age1Day(item)
        item.updateQuality()
    }

    private fun Item.updateQuality() {
        // Once the sell by date has passed, Quality degrades twice as fast
        val minus = if (sellIn >= 0) 1 else 2
        if(quality - minus <= 0) quality = 0
        else quality -= minus
    }
}