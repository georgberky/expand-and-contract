package dev.berky.georg;

public class StandardGildedItem implements GildedItem {
    private final Item item;

    public StandardGildedItem(Item item) {
        this.item = item;
    }

    @Override
    public void increaseQuality() {
        this.item.quality++;
    }

    @Override
    public void decreaseQuality() {
        this.item.quality--;
    }

    @Override
    public void loseAllQuality() {
        this.item.quality = 0;
    }

    @Override
    public void decreaseSellIn() {
        this.item.sellIn--;
    }
}
