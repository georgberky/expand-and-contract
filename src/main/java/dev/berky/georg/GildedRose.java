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
            var gildedItem = gildedItems[i];

            gildedItem.updateQuality();
        }
    }

}
