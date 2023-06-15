package dev.berky.georg;

public class AgedBrie implements GildedItem {
    private final String name = "Aged Brie";
    private int sellIn;
    private int quality;

    public AgedBrie(Item item) {
        this(item.sellIn, item.quality);
    }

    public AgedBrie(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
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
