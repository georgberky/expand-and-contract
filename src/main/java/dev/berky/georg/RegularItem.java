package dev.berky.georg;

public class RegularItem implements GildedItem {
    private final Item item;

    public RegularItem(Item item) {
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

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            decreaseQuality();
        }

        decreaseSellIn();

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality();
        }
    }
}