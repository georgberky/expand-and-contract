package dev.berky.georg;

public class AgedBrie implements GildedItem {
    private final Item item;
    private final String name = "Aged Brie";

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void increaseQuality() {
        this.item.quality++;
    }

    @Override
    public void decreaseQuality() {
        //doesn't happen
    }

    @Override
    public void loseAllQuality() {
        //doesn't happen
    }

    @Override
    public void decreaseSellIn() {
        this.item.sellIn--;
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50) {
            increaseQuality();
        }

        decreaseSellIn();

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                increaseQuality();
            }
        }
    }
}
