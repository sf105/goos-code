package auctionsniper;

import java.util.EventListener;

public interface SniperListener extends EventListener { 
  void sniperStateChanged(SniperSnapshot snapshot);
}