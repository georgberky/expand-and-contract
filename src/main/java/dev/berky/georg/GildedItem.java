package dev.berky.georg;

public interface GildedItem {

    static GildedItem from(String name, int sellIn, int quality) {
        Item item = new Item(name, sellIn, quality);
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrie(item.sellIn, item.quality);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePasses(item.sellIn, item.quality);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(item.sellIn, item.quality);
            default -> new RegularItem(item.name, item.sellIn, item.quality);
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
