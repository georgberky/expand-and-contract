package dev.berky.georg;

public class RegularItem implements GildedItem {
    private final Item item;

    public RegularItem(Item item) {
        this.item = item;
    }

    @Override
    public String name() {
        return item.name;
    }

    @Override
    public int quality() {
        return item.quality;
    }

    @Override
    public int sellIn() {
        return item.sellIn;
    }

    @Override
    @Deprecated
    public void increaseQuality() {
        //doesn't happen
    }

    @Override
    public void decreaseQuality() {
        this.item.quality--;
    }

    @Override
    @Deprecated
    public void loseAllQuality() {
        //doesn't happen
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
