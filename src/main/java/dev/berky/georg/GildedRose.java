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

    public GildedRose(GildedItem[] gildedItems) {
        this.gildedItems = gildedItems;
        this.items = Arrays.stream(gildedItems)
                .map(it -> new Item(it.name(), it.sellIn(), it.quality()))
                .toArray(Item[]::new);
    }

    public void updateQuality() {
        Arrays.stream(gildedItems)
            .forEach(GildedItem::updateQuality);
    }

}
