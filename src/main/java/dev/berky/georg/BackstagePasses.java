package dev.berky.georg;

public class BackstagePasses implements GildedItem {
    private final Item item;
    private final String name = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(Item item) {
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
        this.item.quality = 0;
    }

    @Override
    public void decreaseSellIn() {
        this.item.sellIn--;
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50) {
            increaseQuality();

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    increaseQuality();
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    increaseQuality();
                }
            }
        }

        decreaseSellIn();

        if (item.sellIn < 0) {
            loseAllQuality();
        }
    }
}
