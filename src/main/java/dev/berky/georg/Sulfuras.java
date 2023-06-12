package dev.berky.georg;

public class Sulfuras implements GildedItem {
    private final Item item;
    private final String name = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        this.item = item;
    }

    @Override
    public void increaseQuality() {
        //doesn't happen
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
        //doesn't happen
    }

    @Override
    public void updateQuality() {
        //nothing to do
    }
}
