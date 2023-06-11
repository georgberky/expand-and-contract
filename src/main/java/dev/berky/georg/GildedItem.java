package dev.berky.georg;

public interface GildedItem {
    static GildedItem from(Item item) {
        return switch(item.name) {
            case "Aged Brie" -> new AgedBrie(item);
            default -> new StandardGildedItem(item);
        };
    }

    void increaseQuality();

    void decreaseQuality();

    void loseAllQuality();

    void decreaseSellIn();

    void updateQuality();
}
