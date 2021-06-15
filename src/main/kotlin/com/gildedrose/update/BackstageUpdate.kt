package com.gildedrose.update

import com.gildedrose.Item
import com.gildedrose.MAX_QUALITY

class BackstageUpdate : BaseUpdate() {

    /**
        "Backstage passes" increases in Quality as its SellIn value approaches;
        Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        Quality drops to 0 after the concert
     */

    override fun age1Day(item: Item) {
        super.age1Day(item)
        item.updateQuality()
    }

    private fun Item.updateQuality() {
        when {
            sellIn < 0 -> quality = 0
            sellIn < 5 -> quality += 3
            sellIn < 10 -> quality += 2
            quality < MAX_QUALITY -> quality += 1
        }
    }
}