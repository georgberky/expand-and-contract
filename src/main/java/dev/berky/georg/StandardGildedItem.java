package dev.berky.georg;

public class StandardGildedItem implements GildedItem {
    private final Item item;
    private final String name;

    public StandardGildedItem(Item item) {
        this.item = item;
        this.name = item.name;
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
