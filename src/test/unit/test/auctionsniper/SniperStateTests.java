package test.auctionsniper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import auctionsniper.SniperState;
import auctionsniper.util.Defect;

public class SniperStateTests {

  @Test public void
  isWonWhenAuctionClosesWhileWinning() {
    assertEquals(SniperState.LOST, SniperState.JOINING.whenAuctionClosed());
    assertEquals(SniperState.LOST, SniperState.BIDDING.whenAuctionClosed());
    assertEquals(SniperState.WON, SniperState.WINNING.whenAuctionClosed());
  }
  
  @Test(expected=Defect.class) public void
  defectIfAuctionClosesWhenWon() {
    SniperState.WON.whenAuctionClosed();
  }

  @Test(expected=Defect.class) public void
  defectIfAuctionClosesWhenLost() {
    SniperState.LOST.whenAuctionClosed();
  }

}
