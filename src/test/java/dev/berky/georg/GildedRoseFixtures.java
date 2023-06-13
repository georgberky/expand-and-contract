package dev.berky.georg;

import static org.assertj.core.api.Assertions.assertThat;

final class GildedRoseFixtures {
    public static Item givenItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

    public static int maxQuality() {
        return 50;
    }

    public static int anyQuality() {
        return 10;
    }

    public static int zeroQuality() {
        return 0;
    }

    public static int anySellInDate() {
        return 1;
    }

    public static int notPastSellInDate() {
        return 3;
    }

    public static int pastSellInDate() {
        return -1;
    }

    public static void whenOneDayPasses(Item item) {
        GildedRose app = createApp(item);
        app.updateQuality();
    }

    public static GildedRose createApp(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }

    public static void assertThatItemHasQuality(Item item, int expected) {
        assertThat(item.quality).isEqualTo(expected);
    }

    public static void assertThatItemHasSellIn(Item item, int expected) {
        assertThat(item.sellIn).isEqualTo(expected);
    }
}
