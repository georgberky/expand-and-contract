package dev.berky.georg;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static dev.berky.georg.GildedRoseFixtures.notPastSellInDate;
import static dev.berky.georg.GildedRoseFixtures.whenOneDayPasses;
import static org.assertj.core.api.Assertions.assertThat;

class SulfurasTest {

    @ParameterizedTest(name = "initial quality: {0}")
    @ValueSource(ints = { 10, 11, 12 })
    @DisplayName("Sulfuras: does not change quality")
    void whenDayPasses_itemSulfuras__shouldNotChangeQuality(int initialQuality) {
        Item item = new Item("Sulfuras, Hand of Ragnaros", notPastSellInDate(), initialQuality);

        whenOneDayPasses(item);

        assertThat(item.quality).isEqualTo(initialQuality);
    }
}
