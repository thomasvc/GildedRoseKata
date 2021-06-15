package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class SpecialGoodTests {

    companion object {
        const val SELL_IN = 2
        const val QUALITY = 1
        const val MAX_QUALITY = 50
        const val SULFURAS_QUALITY = 80
        private const val BRIE = "Aged Brie"
        private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
        private const val CONJURED = "Conjured Mana Cake"
        val agedBrie = Item(BRIE, SELL_IN, QUALITY)
        val agedBrieMaxQuality = Item(BRIE, SELL_IN, MAX_QUALITY)
        val sulfuras = Item(SULFURAS, SELL_IN, SULFURAS_QUALITY)
        val conjured = Item(CONJURED, SELL_IN, MAX_QUALITY)
    }

    @Test
    fun `Aged Brie actually increases in Quality the older it gets`() {
        val app = GildedRose(arrayOf(agedBrie))
        app.updateQuality()
        Assertions.assertTrue(app.items[0].quality > QUALITY)
    }

    @Test
    fun `The Quality of an item is never more than 50`() {
        val app = GildedRose(arrayOf(agedBrieMaxQuality))
        app.updateQuality()
        Assertions.assertEquals(MAX_QUALITY, app.items[0].quality)
    }

    @Test
    fun `Sulfuras, being a legendary item, never has to be sold or decreases in Quality`() {
        val app = GildedRose(arrayOf(sulfuras))
        app.updateQuality()
        Assertions.assertAll(
            Executable { Assertions.assertEquals(SELL_IN, app.items[0].sellIn) },
            Executable { Assertions.assertEquals(SULFURAS_QUALITY, app.items[0].quality) }
        )
    }

    @Test
    fun `Backstage passes quality increases by 1 when there are more then 10 days left`() {
        val sellIn = 15
        val quality = 10
        val app = GildedRose(arrayOf(Item(BACKSTAGE, sellIn, quality)))
        for(i in 1..5) {
            app.updateQuality()
            Assertions.assertAll(
                Executable { Assertions.assertEquals(sellIn - i, app.items[0].sellIn) },
                Executable { Assertions.assertEquals(quality + i, app.items[0].quality) }
            )
        }
    }

    @Test
    fun `Backstage passes quality increases by 2 when there are 10 days left`() {
        val sellIn = 10
        val quality = 10
        val app = GildedRose(arrayOf(Item(BACKSTAGE, sellIn, quality)))
        for(i in 1..5) {
            app.updateQuality()
            Assertions.assertAll(
                Executable { Assertions.assertEquals(sellIn - i, app.items[0].sellIn) },
                Executable { Assertions.assertEquals(quality + (2 * i), app.items[0].quality) }
            )
        }
    }

    @Test
    fun `Backstage passes quality increases by 3 when there are 5 days left`() {
        val sellIn = 5
        val quality = 10
        val app = GildedRose(arrayOf(Item(BACKSTAGE, sellIn, quality)))
        for(i in 1..5) {
            app.updateQuality()
            Assertions.assertAll(
                Executable { Assertions.assertEquals(sellIn - i, app.items[0].sellIn) },
                Executable { Assertions.assertEquals(quality + (3 * i), app.items[0].quality) }
            )
        }
    }

    @Test
    fun `Backstage passes quality drops to 0 after the concert`() {
        val sellIn = 0
        val quality = 10
        val app = GildedRose(arrayOf(Item(BACKSTAGE, sellIn, quality)))
        for(i in 1..5) {
            app.updateQuality()
            Assertions.assertAll(
                Executable { Assertions.assertEquals(sellIn - i, app.items[0].sellIn) },
                Executable { Assertions.assertEquals(0, app.items[0].quality) }
            )
        }
    }

    @Test
    fun `Conjured items degrade in Quality twice as fast as normal items`() {
        val app = GildedRose(arrayOf(conjured))
        for (i in 1..SELL_IN) {
            app.updateQuality()
            Assertions.assertEquals(MAX_QUALITY - (i * 2), app.items[0].quality)
        }
    }
}