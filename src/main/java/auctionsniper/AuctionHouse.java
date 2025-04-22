package auctionsniper;

import auctionsniper.UserRequestListener.Item;

public interface AuctionHouse {
  Auction auctionFor(Item item); 
}
