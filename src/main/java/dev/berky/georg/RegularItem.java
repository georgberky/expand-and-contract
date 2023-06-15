package dev.berky.georg;

public class RegularItem implements GildedItem {
    private final String name;
    private int quality;
    private int sellIn;

    public RegularItem(Item item) {
        this(item.name, item.sellIn, item.quality);
    }

    public RegularItem(String name, int sellIn, int quality) {
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
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
