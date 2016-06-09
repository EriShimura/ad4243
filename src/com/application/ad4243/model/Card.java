package com.application.ad4243.model;

import javax.jdo.annotations.*;;

/**
*
* @author g13943se
*/
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Card {
	@PrimaryKey
	@Persistent
   int cardId;
	
	@Persistent
   int cardRarity;
	
	@Persistent
   String cardName;
	
	@Persistent
   String cardDetails;
	
	@Persistent
   String cardAddress;
	
	@Persistent
   String cardOwner;
	
   public Card(int cardId, int cardRarity, String cardName,
           String cardDetails,String cardAddress,String cardOwner){
       this.cardId = cardId;
       this.cardRarity = cardRarity;
       this.cardName = cardName;
       this.cardDetails = cardDetails;
       this.cardAddress = cardAddress;
       this.cardOwner = cardOwner;
   }
   public int getCardId(){ return cardId; }
   public int getCardRarity(){ return cardRarity; }
   public String getCardName(){ return cardName; }
   public String getCardDetails(){ return cardDetails; }
   public String getCardAddress(){ return cardAddress; }
   public String getCardOwner(){ return cardOwner; }
   public void setCardOwner(int owner){ cardOwner += " " + String.valueOf(owner); }
}
