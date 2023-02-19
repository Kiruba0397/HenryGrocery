package com.ford;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Henry {
	   public double getDiscountRate(LocalDate purchaseDate) {
	        // Determine if it's Tuesday
	        if (purchaseDate.getDayOfWeek() == DayOfWeek.TUESDAY) {
	            return 0.1; // 10% discount on Tuesdays
	        } else {
	            return 0.0; // No discount on other days
	        }
	    }
}
