package dev.berky.georg;

public interface GildedItem {
    static GildedItem from(Item item) {
        return switch(item.name) {
            case "Aged Brie" -> new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePasses(item);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(item);
            default -> new RegularItem(item);
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
