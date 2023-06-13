package dev.berky.georg;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static dev.berky.georg.GildedRoseFixtures.anySellInDate;
import static dev.berky.georg.GildedRoseFixtures.maxQuality;
import static dev.berky.georg.GildedRoseFixtures.notPastSellInDate;
import static dev.berky.georg.GildedRoseFixtures.pastSellInDate;

import static dev.berky.georg.GildedRoseFixtures.givenItem;
import static dev.berky.georg.GildedRoseFixtures.whenOneDayPasses;
import static dev.berky.georg.GildedRoseFixtures.assertThatItemHasQuality;

class AgedBrieTest {

    @ParameterizedTest(name = "initial quality: {0}")
    @ValueSource(ints = { 10, 11, 12 })
    @DisplayName("Aged Brie: increases quality")
    void whenDayPasses_itemAgedBrie_shouldIncreaseQualityByOne(int initialQuality) {
        var item = givenItem("Aged Brie", notPastSellInDate(), initialQuality);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, initialQuality + 1);
    }

    @Test
    @DisplayName("Aged Brie: does not increase quality above maximum")
    void whenDayPasses_itemAgedBrieWithQualityFifty_shouldNotIncreaseQuality() {
        var item = givenItem("Aged Brie", anySellInDate(), maxQuality());

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, maxQuality());
    }

    @ParameterizedTest(name = "initial quality: {0}")
    @ValueSource(ints = { 46, 47, 48 })
    @DisplayName("Aged Brie: increases quality past sell-in date by two")
    void afterSellInDate_AgedBrie_increasesInQuality(int initialQuality) {
        var item = givenItem("Aged Brie", pastSellInDate(), initialQuality);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, initialQuality + 2);
    }
}
