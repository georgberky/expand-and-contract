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
        if (!name.equals("Aged Brie")
                && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                    decreaseQuality();
                }
            }
        } else {
            if (item.quality < 50) {
                increaseQuality();

                if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
            }
        }

        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseSellIn();
        }

        if (item.sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            decreaseQuality();
                        }
                    }
                } else {
                    loseAllQuality();
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality();
                }
            }
        }
    }
}
