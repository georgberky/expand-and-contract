package dev.berky.georg;

public interface GildedItem {
    static GildedItem from(Item item) {
        return new StandardGildedItem(item);
    }

    void increaseQuality();

    void decreaseQuality();

    void loseAllQuality();

    void decreaseSellIn();
}
