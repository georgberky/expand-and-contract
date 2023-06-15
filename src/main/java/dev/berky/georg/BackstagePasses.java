package dev.berky.georg;

public class BackstagePasses implements GildedItem {
    private final String name = "Backstage passes to a TAFKAL80ETC concert";
    private int quality;
    private int sellIn;

    public BackstagePasses(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int quality() {
        return quality;
    }

    @Override
    public int sellIn() {
        return sellIn;
    }

    @Override
    public void increaseQuality() {
        quality++;
    }

    @Override
    @Deprecated
    public void decreaseQuality() {
        //doesn't happen
    }

    @Override
    public void loseAllQuality() {
        quality = 0;
    }

    @Override
    public void decreaseSellIn() {
        sellIn--;
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            increaseQuality();

            if (sellIn < 11) {
                if (quality < 50) {
                    increaseQuality();
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    increaseQuality();
                }
            }
        }

        decreaseSellIn();

        if (sellIn < 0) {
            loseAllQuality();
        }
    }
}
