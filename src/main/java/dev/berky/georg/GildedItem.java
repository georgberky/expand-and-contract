package dev.berky.georg;

public class GildedItem {
    private final Item item;

    public GildedItem(Item item) {
        this.item = item;
    }

    public void decreaseQuality() {
        this.item.quality--;
    }

    public void increaseQuality() {
        this.item.quality++;
    }
}
