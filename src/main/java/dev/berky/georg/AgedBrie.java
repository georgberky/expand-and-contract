package dev.berky.georg;

public class AgedBrie implements GildedItem {
    private final String name = "Aged Brie";
    private int quality;
    private int sellIn;

    public AgedBrie(Item item) {
        this.quality = item.quality;
        this.sellIn = item.sellIn;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int quality() {
        return quality;
    }

    @Override
    public int sellIn() {
        return sellIn;
    }

    @Override
    public void increaseQuality() {
        quality++;
    }

    @Override
    @Deprecated
    public void decreaseQuality() {
        //doesn't happen
    }

    @Override
    @Deprecated
    public void loseAllQuality() {
        //doesn't happen
    }

    @Override
    public void decreaseSellIn() {
        sellIn--;
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            increaseQuality();
        }

        decreaseSellIn();

        if (sellIn < 0) {
            if (quality < 50) {
                increaseQuality();
            }
        }
    }
}
