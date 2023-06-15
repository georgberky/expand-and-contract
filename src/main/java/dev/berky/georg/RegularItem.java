package dev.berky.georg;

public class RegularItem implements GildedItem {
    private final String name;
    private int quality;
    private int sellIn;

    public RegularItem(Item item) {
        this.name = item.name;
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
    @Deprecated
    public void increaseQuality() {
        //doesn't happen
    }

    @Override
    public void decreaseQuality() {
        quality--;
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
        if (quality > 0) {
            decreaseQuality();
        }

        decreaseSellIn();

        if (sellIn < 0 && quality > 0) {
            decreaseQuality();
        }
    }
}
