package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

internal class StandardGoodTests {

    companion object {
        const val SELL_IN = 10
        private const val SELL_IN_LAST_DAY = 0
        const val QUALITY = 20
        const val standardGood = "+5 Dexterity Vest"
    }

    @Test
    fun `The sellIn and quality should be - 1 after 1 updateQuality`() {
        val app = GildedRose(arrayOf(Item(standardGood, SELL_IN, QUALITY)))
        app.updateQuality()
        Assertions.assertAll(
            Executable { Assertions.assertEquals(SELL_IN - 1, app.items[0].sellIn) },
            Executable { Assertions.assertEquals(QUALITY - 1, app.items[0].quality) }
        )
    }

    @Test
    fun `The sellIn and quality should be consistently being lowered until sellIn`() {
        val app = GildedRose(arrayOf(Item(standardGood, SELL_IN, QUALITY)))
        for (i in 1..SELL_IN) {
            app.updateQuality()
            Assertions.assertAll(
                Executable { Assertions.assertEquals(SELL_IN - i, app.items[0].sellIn) },
                Executable { Assertions.assertEquals(QUALITY - i, app.items[0].quality) }
            )
        }
    }

    @Test
    fun `The quality should be degrade twice as fast after the sellIn`() {
        val app = GildedRose(arrayOf(Item(standardGood, SELL_IN_LAST_DAY, QUALITY)))
        for (i in 1..5) {
            app.updateQuality()
            Assertions.assertEquals(QUALITY - (i * 2), app.items[0].quality)
        }
    }

    @Test
    fun `The Quality of an item is never negative`() {
        val app = GildedRose(arrayOf(Item(standardGood, SELL_IN_LAST_DAY, QUALITY)))
        for (i in 1..21) {
            app.updateQuality()
            Assertions.assertTrue(app.items[0].quality >= 0)
        }
    }


}