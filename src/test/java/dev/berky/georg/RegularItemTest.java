package dev.berky.georg;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static dev.berky.georg.GildedRoseFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class RegularItemTest {

    @ParameterizedTest(name = "initial quality: {0}")
    @ValueSource(ints = {10, 11, 12})
    @DisplayName("Regular Item: decreases quality by one")
    void whenDayPasses_normalItem_shouldDecreaseQualityByOne(int initialQuality) {
        var item = givenItem("regular item", notPastSellInDate(), initialQuality);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, initialQuality - 1);
    }

    @ParameterizedTest(name = "initial sell-in days: {0}")
    @ValueSource(ints = {10, 11, 12})
    @DisplayName("Regular Item: decreases sell-in days by one")
    void whenDayPasses_normalItem_shouldDecreaseSellInDateByOne(int initialSellInDate) {
        var item = givenItem("regular item", initialSellInDate, anyQuality());

        whenOneDayPasses(item);

        assertThat(item.sellIn).isEqualTo(initialSellInDate - 1);
    }

    @Test
    @DisplayName("Regular item: does not decrease quality below zero")
    void whenDayPasses_normalItemWithZeroQuality_shouldNotDecreaseQuality() {
        var item = givenItem("regular item", anySellInDate(), zeroQuality());

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, zeroQuality());
    }

    @ParameterizedTest(name = "initial quality: {0}")
    @ValueSource(ints = {10, 11, 12})
    @DisplayName("Regular item: past sell in date → decreases quality by two")
    void whenDayPasses_normalItemWithNegativeSellDate_shouldDecreaseQualityeByTwo(int initialQuality) {
        var item = givenItem("regular item", pastSellInDate(), initialQuality);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, initialQuality - 2);
    }
}
