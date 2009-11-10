package auctionsniper.xmpp;

public interface XMPPFailureReporter { 
  void cannotTranslateMessage(String auctionId, String failedMessage, Exception exception);
}