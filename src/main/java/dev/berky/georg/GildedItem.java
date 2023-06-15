package dev.berky.georg;

public interface GildedItem {

    static GildedItem from(String name, int sellIn, int quality) {
        return switch (name) {
            case "Aged Brie" -> new AgedBrie(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePasses(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(sellIn, quality);
            default -> new RegularItem(name, sellIn, quality);
        };
    }

    String name();

    int quality();

    int sellIn();

    void increaseQuality();

    void decreaseQuality();

    void loseAllQuality();

    void decreaseSellIn();

    void updateQuality();
}
