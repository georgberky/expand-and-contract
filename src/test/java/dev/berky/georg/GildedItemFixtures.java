package dev.berky.georg;

import static org.assertj.core.api.Assertions.assertThat;

final class GildedItemFixtures {
    public static GildedItem givenItem(String name, int sellIn, int quality) {
        return GildedItem.from(name, sellIn, quality);
    }

    public static void whenOneDayPasses(GildedItem item) {
        GildedItem[] items = new GildedItem[]{item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    }

    public static void assertThatItemHasQuality(GildedItem item, int expected) {
        assertThat(item.quality()).isEqualTo(expected);
    }

    public static void assertThatItemHasSellIn(GildedItem item, int expected) {
        assertThat(item.sellIn()).isEqualTo(expected);
    }
}
