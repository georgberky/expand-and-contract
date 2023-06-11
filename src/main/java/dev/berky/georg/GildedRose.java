package dev.berky.georg;

import java.util.Arrays;

class GildedRose {
    Item[] items;
    GildedItem[] gildedItems;

    public GildedRose(Item[] items) {
        this.items = items;
        this.gildedItems = Arrays.stream(items)
            .map(StandardGildedItem::new)
            .toArray(GildedItem[]::new);
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        gildedItems[i].decreaseQuality();
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    gildedItems[i].increaseQuality();

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                gildedItems[i].increaseQuality();
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                gildedItems[i].increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                gildedItems[i].decreaseSellIn();
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                gildedItems[i].decreaseQuality();
                            }
                        }
                    } else {
                        gildedItems[i].loseAllQuality();
                    }
                } else {
                    if (items[i].quality < 50) {
                        gildedItems[i].increaseQuality();
                    }
                }
            }
        }
    }
}
