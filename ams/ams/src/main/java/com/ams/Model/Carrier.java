package com.ams.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrier")
public class Carrier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CarrierID;
	private String CarrierName;
	private int DiscountPercentageThirtyDaysAdvanceBooking;
	private int DiscountPercentageSixtyDaysAdvanceBooking;
	private int DiscountPercentageNinteyDaysAdvanceBooking;
	private int BulkBookingDiscount;
	private int RefundPercentageForTicketCancellation2DaysBeforeTravelDate;
	private int RefundPercentageForTicketCancellation10DaysBeforeTravelDate;
	private int RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
	private int SilverUserDiscount;
	private int GoldUserDiscount;
	private int PlatinumUserDiscount;
	public Carrier() {
		
	}
	public Carrier(int carrierID, String carrierName, int discountPercentageThirtyDaysAdvanceBooking,
			int discountPercentageSixtyDaysAdvanceBooking, int discountPercentageNinteyDaysAdvanceBooking,
			int bulkBookingDiscount, int refundPercentageForTicketCancellation2DaysBeforeTravelDate,
			int refundPercentageForTicketCancellation10DaysBeforeTravelDate,
			int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate, int silverUserDiscount,
			int goldUserDiscount, int platinumUserDiscount) {
		super();
		CarrierID = carrierID;
		CarrierName = carrierName;
		DiscountPercentageThirtyDaysAdvanceBooking = discountPercentageThirtyDaysAdvanceBooking;
		DiscountPercentageSixtyDaysAdvanceBooking = discountPercentageSixtyDaysAdvanceBooking;
		DiscountPercentageNinteyDaysAdvanceBooking = discountPercentageNinteyDaysAdvanceBooking;
		BulkBookingDiscount = bulkBookingDiscount;
		RefundPercentageForTicketCancellation2DaysBeforeTravelDate = refundPercentageForTicketCancellation2DaysBeforeTravelDate;
		RefundPercentageForTicketCancellation10DaysBeforeTravelDate = refundPercentageForTicketCancellation10DaysBeforeTravelDate;
		RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate = refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
		SilverUserDiscount = silverUserDiscount;
		GoldUserDiscount = goldUserDiscount;
		PlatinumUserDiscount = platinumUserDiscount;
	}
	public int getCarrierID() {
		return CarrierID;
	}
	public void setCarrierID(int carrierID) {
		CarrierID = carrierID;
	}
	public String getCarrierName() {
		return CarrierName;
	}
	public void setCarrierName(String carrierName) {
		CarrierName = carrierName;
	}
	public int getDiscountPercentageThirtyDaysAdvanceBooking() {
		return DiscountPercentageThirtyDaysAdvanceBooking;
	}
	public void setDiscountPercentageThirtyDaysAdvanceBooking(int discountPercentageThirtyDaysAdvanceBooking) {
		DiscountPercentageThirtyDaysAdvanceBooking = discountPercentageThirtyDaysAdvanceBooking;
	}
	public int getDiscountPercentageSixtyDaysAdvanceBooking() {
		return DiscountPercentageSixtyDaysAdvanceBooking;
	}
	public void setDiscountPercentageSixtyDaysAdvanceBooking(int discountPercentageSixtyDaysAdvanceBooking) {
		DiscountPercentageSixtyDaysAdvanceBooking = discountPercentageSixtyDaysAdvanceBooking;
	}
	public int getDiscountPercentageNinteyDaysAdvanceBooking() {
		return DiscountPercentageNinteyDaysAdvanceBooking;
	}
	public void setDiscountPercentageNinteyDaysAdvanceBooking(int discountPercentageNinteyDaysAdvanceBooking) {
		DiscountPercentageNinteyDaysAdvanceBooking = discountPercentageNinteyDaysAdvanceBooking;
	}
	public int getBulkBookingDiscount() {
		return BulkBookingDiscount;
	}
	public void setBulkBookingDiscount(int bulkBookingDiscount) {
		BulkBookingDiscount = bulkBookingDiscount;
	}
	public int getRefundPercentageForTicketCancellation2DaysBeforeTravelDate() {
		return RefundPercentageForTicketCancellation2DaysBeforeTravelDate;
	}
	public void setRefundPercentageForTicketCancellation2DaysBeforeTravelDate(
			int refundPercentageForTicketCancellation2DaysBeforeTravelDate) {
		RefundPercentageForTicketCancellation2DaysBeforeTravelDate = refundPercentageForTicketCancellation2DaysBeforeTravelDate;
	}
	public int getRefundPercentageForTicketCancellation10DaysBeforeTravelDate() {
		return RefundPercentageForTicketCancellation10DaysBeforeTravelDate;
	}
	public void setRefundPercentageForTicketCancellation10DaysBeforeTravelDate(
			int refundPercentageForTicketCancellation10DaysBeforeTravelDate) {
		RefundPercentageForTicketCancellation10DaysBeforeTravelDate = refundPercentageForTicketCancellation10DaysBeforeTravelDate;
	}
	public int getRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate() {
		return RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
	}
	public void setRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate(
			int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate) {
		RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate = refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
	}
	public int getSilverUserDiscount() {
		return SilverUserDiscount;
	}
	public void setSilverUserDiscount(int silverUserDiscount) {
		SilverUserDiscount = silverUserDiscount;
	}
	public int getGoldUserDiscount() {
		return GoldUserDiscount;
	}
	public void setGoldUserDiscount(int goldUserDiscount) {
		GoldUserDiscount = goldUserDiscount;
	}
	public int getPlatinumUserDiscount() {
		return PlatinumUserDiscount;
	}
	public void setPlatinumUserDiscount(int platinumUserDiscount) {
		PlatinumUserDiscount = platinumUserDiscount;
	}
}