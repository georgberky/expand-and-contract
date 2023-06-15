package dev.berky.georg;

public class Sulfuras implements GildedItem {
    private final String name = "Sulfuras, Hand of Ragnaros";
    private final int sellIn;
    private final int quality;

    public Sulfuras(Item item) {
        this.sellIn = item.sellIn;
        this.quality = item.quality;
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
    @Deprecated
    public void decreaseSellIn() {
        //doesn't happen
    }

    @Override
    public void updateQuality() {
        //nothing to do
    }
}
