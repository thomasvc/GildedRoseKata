package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != BRIE_NAME && items[i].name != BACKSTAGE_PASS_NAME) {
                if (items[i].quality > MIN_QUALITY) {
                    if (items[i].name != SULFURAS_NAME) {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < MAX_QUALITY) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == BACKSTAGE_PASS_NAME) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < MAX_QUALITY) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < MAX_QUALITY) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != SULFURAS_NAME) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != BRIE_NAME) {
                    if (items[i].name != BACKSTAGE_PASS_NAME) {
                        if (items[i].quality > MIN_QUALITY) {
                            if (items[i].name != SULFURAS_NAME) {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < MAX_QUALITY) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

}

