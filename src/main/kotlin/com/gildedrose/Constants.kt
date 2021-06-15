package com.gildedrose

import com.gildedrose.update.AgeOneDay
import com.gildedrose.update.BackstageUpdate
import com.gildedrose.update.BrieUpdate
import com.gildedrose.update.SulfurasUpdate

// MIN & MAX values
const val MIN_QUALITY = 0
const val MAX_QUALITY = 50

const val DEFAULT_SELLIN_DECREASE = 1
const val DEFAULT_QUALITY_DECREASE = 1
const val DEFAULT_QUALITY_INCREASE = 1

// All special goods
const val BRIE_NAME = "Aged Brie"
const val BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS_NAME = "Sulfuras, Hand of Ragnaros"

const val CONJURED_LOWERCASE = "conjured"

val updaters = hashMapOf<String, AgeOneDay>(
    BRIE_NAME to BrieUpdate(),
    SULFURAS_NAME to SulfurasUpdate(),
    BACKSTAGE_PASS_NAME to BackstageUpdate()
)
