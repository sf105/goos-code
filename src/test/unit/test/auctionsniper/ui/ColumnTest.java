package test.auctionsniper.ui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import auctionsniper.SniperSnapshot;
import auctionsniper.SniperState;
import auctionsniper.ui.Column;

public class ColumnTest {

  @Test public void
  retrievesValuesFromASniperSnapshot() {
    SniperSnapshot snapshot = new SniperSnapshot("item", 123, 34, SniperState.BIDDING);
    assertEquals("item", Column.ITEM_IDENTIFIER.valueIn(snapshot));
    assertEquals(123, Column.LAST_PRICE.valueIn(snapshot));
    assertEquals(34, Column.LAST_BID.valueIn(snapshot));
    assertEquals("Bidding", Column.SNIPER_STATE.valueIn(snapshot));
  }
}
