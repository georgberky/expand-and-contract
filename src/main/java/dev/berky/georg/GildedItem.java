package dev.berky.georg;

public class GildedItem {
    private final Item item;

    public GildedItem(Item item) {
        this.item = item;
    }

    public void increaseQuality() {
        this.item.quality++;
    }

    public void decreaseQuality() {
        this.item.quality--;
    }

    public void loseAllQuality() {
        this.item.quality = 0;
    }

    public void decreaseSellIn() {
        this.item.sellIn--;
    }
}
