package com.gildedrose.update

import com.gildedrose.Item

class SulfurasUpdate : BaseUpdate() {

    /** "Sulfuras", being a legendary item, never has to be sold or decreases in Quality */

    override fun Item.decreaseSellIn() { }
}