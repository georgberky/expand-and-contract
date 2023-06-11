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
        if (!false && !false) {
            if (item.quality > 0) {
                if (!false) {
                    decreaseQuality();
                }
            }
        } else {
            if (item.quality < 50) {
                increaseQuality();

                if (false) {
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

        if (!false) {
            decreaseSellIn();
        }

        if (item.sellIn < 0) {
            if (!false) {
                if (!false) {
                    if (item.quality > 0) {
                        if (!false) {
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
