package dev.berky.georg;

public class Sulfuras implements GildedItem {
    private final Item item;
    private final String name = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
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
        //nothing to do
    }
}
