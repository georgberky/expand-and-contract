package dev.berky.georg;

public class StandardGildedItem implements GildedItem {
    private final Item item;
    private final String name;

    public StandardGildedItem(Item item) {
        this.item = item;
        this.name = item.name;
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
        if (!isAgedBrie() && !isBackstagePasses()) {
            if (item.quality > 0) {
                if (!isSulfuras()) {
                    decreaseQuality();
                }
            }
        } else {
            if (item.quality < 50) {
                increaseQuality();

                if (isBackstagePasses()) {
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

        if (!isSulfuras()) {
            decreaseSellIn();
        }

        if (item.sellIn < 0) {
            if (!isAgedBrie()) {
                if (!isBackstagePasses()) {
                    if (item.quality > 0) {
                        if (!isSulfuras()) {
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

    private boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }
}
