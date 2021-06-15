package com.gildedrose.update

import com.gildedrose.DEFAULT_SELLIN_DECREASE
import com.gildedrose.Item

abstract class BaseUpdate : AgeOneDay {

    override fun age1Day(item: Item) {
        item.decreaseSellIn()
    }

    open fun Item.decreaseSellIn() {
        sellIn -= DEFAULT_SELLIN_DECREASE
    }
}