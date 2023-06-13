package dev.berky.georg;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import static dev.berky.georg.GildedRoseFixtures.maxQuality;
import static dev.berky.georg.GildedRoseFixtures.zeroQuality;

import static dev.berky.georg.GildedItemFixtures.givenItem;
import static dev.berky.georg.GildedItemFixtures.whenOneDayPasses;
import static dev.berky.georg.GildedItemFixtures.assertThatItemHasQuality;

class BackstagePassesTest {

    @ParameterizedTest(name = "initial sell-in days: {0}, initial quality: {1}")
    @MethodSource("backstagePassesDaysBetween10and5")
    @DisplayName("Backstage passes: sell-in days ⩽ 10 → increase quality by 2")
    void backstagePasses_sellInLessThan11_increaseQualityBy2UpTo50(int initialSellIn, int initialQuality) {
        var item = givenItem("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, initialQuality + 2);
    }

    static Stream<Arguments> backstagePassesDaysBetween10and5() {
        List<Arguments> arguments = new LinkedList<>();

        for (int initialSellInDays = 10; initialSellInDays > 5; initialSellInDays--) {
            for (int initialQuality = 48; initialQuality >= 46; initialQuality--) {
                arguments.add(arguments(initialSellInDays, initialQuality));
            }
        }

        return arguments.stream();
    }

    @Test
    @DisplayName("Backstage passes: sell-in days ⩽ 10 → do not increase quality above maximum")
    void backstagePasses_sellInLessThan11_doesNotIncreaseQualityBeyond50() {
        var item = givenItem("Backstage passes to a TAFKAL80ETC concert", 10, 49);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, maxQuality());
    }

    @ParameterizedTest(name = "initial sell-in days: {0}, initial quality: {1}")
    @MethodSource("backstagePassesDaysBetween5And0")
    @DisplayName("Backstage passes: sell-in days ⩽ 5 → increase quality by 2")
    void backstagePasses_sellInLessThan6_increasesQualityBy3UpTo50_(int initialSellIn, int initialQuality) {
        var item = givenItem("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, initialQuality + 3);
    }

    static Stream<Arguments> backstagePassesDaysBetween5And0() {
        List<Arguments> arguments = new LinkedList<>();

        for (int initialSellInDays = 5; initialSellInDays > 0; initialSellInDays--) {
            for (int initialQuality = 47; initialQuality >= 45; initialQuality--) {
                arguments.add(arguments(initialSellInDays, initialQuality));
            }
        }

        return arguments.stream();
    }

    @Test
    @DisplayName("Backstage passes: sell-in days ⩽ 5 → does not increase quality above maximum")
    void backstagePasses_sellInLessThan6_doesNotIncreaseQualityBeyond50() {
        var item = givenItem("Backstage passes to a TAFKAL80ETC concert", 5, 48);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, maxQuality());
    }

    @ParameterizedTest(name = "initial sell-in days: {0}")
    @ValueSource(ints = {0, -1, -2})
    @DisplayName("Backstage passes: quality is zero after sell-in has passed")
    void backstagePasses_haveQualityZero_whenSellInHasPassed(int pastSellIn) {
        var item = givenItem("Backstage passes to a TAFKAL80ETC concert", pastSellIn, 50);

        whenOneDayPasses(item);

        assertThatItemHasQuality(item, zeroQuality());
    }
}
