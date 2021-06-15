package com.gildedrose.update

import com.gildedrose.Item

abstract class BaseUpdate : AgeOneDay {

    override fun age1Day(item: Item) {
        item.decreaseSellIn()
    }

    open fun Item.decreaseSellIn() {
        sellIn -= 1
    }
}