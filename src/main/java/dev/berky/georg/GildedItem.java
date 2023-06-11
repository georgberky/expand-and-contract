package dev.berky.georg;

public interface GildedItem {
    static GildedItem from(Item item) {
        return switch(item.name) {
            default -> new StandardGildedItem(item);
        };
    }

    void increaseQuality();

    void decreaseQuality();

    void loseAllQuality();

    void decreaseSellIn();

    default void updateQuality(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    decreaseQuality();
                }
            }
        } else {
            if (item.quality < 50) {
                increaseQuality();

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseSellIn();
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
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
