package dev.berky.georg;

import java.util.Arrays;

class GildedRose {
    Item[] items;
    GildedItem[] gildedItems;

    public GildedRose(Item[] items) {
        this.items = items;
        this.gildedItems = Arrays.stream(items)
                .map(GildedItem::from)
                .toArray(GildedItem[]::new);
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            var item = items[i];
            var gildedItem = gildedItems[i];

            updateQuality(item, gildedItem);
        }
    }

    private void updateQuality(Item item, GildedItem gildedItem) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    gildedItem.decreaseQuality();
                }
            }
        } else {
            if (item.quality < 50) {
                gildedItem.increaseQuality();

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            gildedItem.increaseQuality();
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            gildedItem.increaseQuality();
                        }
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            gildedItem.decreaseSellIn();
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            gildedItem.decreaseQuality();
                        }
                    }
                } else {
                    gildedItem.loseAllQuality();
                }
            } else {
                if (item.quality < 50) {
                    gildedItem.increaseQuality();
                }
            }
        }
    }
}
