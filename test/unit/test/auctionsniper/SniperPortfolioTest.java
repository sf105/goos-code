package test.auctionsniper;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import auctionsniper.AuctionSniper;
import auctionsniper.SniperPortfolio;
import auctionsniper.UserRequestListener.Item;
import auctionsniper.SniperPortfolio.PortfolioListener;

@RunWith(JMock.class)
public class SniperPortfolioTest {
  private final Mockery context = new Mockery();
  private final PortfolioListener listener = context.mock(PortfolioListener.class);
  private final SniperPortfolio portfolio = new SniperPortfolio();
  
  @Test public void
  notifiesListenersOfNewSnipers() {
    final AuctionSniper sniper = new AuctionSniper(new Item("item id", 123), null);
    context.checking(new Expectations() {{
      oneOf(listener).sniperAdded(sniper);
    }});
    portfolio.addPortfolioListener(listener);
    
    portfolio.addSniper(sniper);
  }
}
