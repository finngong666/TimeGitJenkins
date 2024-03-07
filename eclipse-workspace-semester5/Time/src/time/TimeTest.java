package time;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


class TimeTest {

	@Test
	public void testGetTotalMillisecondsGood() {
	        int milliseconds = Time.getTotalMilliseconds("05:05:05.500");
	        assertEquals(18305500, milliseconds, "The milliseconds were not calculated properly");
	    }

	@Test
	public void testGetTotalMillisecondsBad() {
	        assertThrows(NumberFormatException.class, () -> {
	            Time.getTotalMilliseconds("10:00:00.00"); 
	        });
	    }

	@Test
	public void testGetTotalMillisecondsBoundary() {
	        int millisecondsAtStartOfDay = Time.getTotalMilliseconds("00:00:00.000");
	        assertEquals(0, millisecondsAtStartOfDay, "Boundary condition failed: start of the day should be 0 milliseconds");
	    }

	@Test
	public void testGetMillisecondsGood() {
	        int milliseconds = Time.getMilliseconds("12:34:56.789");
	        assertEquals(789, milliseconds, "The milliseconds were not calculated properly");
	    }

	  
	@Test
	public void testGetMillisecondsBad() {
	        assertThrows(NumberFormatException.class, () -> {
	            Time.getMilliseconds("12:34:56.78X"); 
	        });
	    }

	@Test
	public void testGetMillisecondsBoundary() {
	        int millisecondsAtStartOfSecond = Time.getMilliseconds("12:34:56.000");
	        assertEquals(0, millisecondsAtStartOfSecond, "Boundary condition failed: start of a second should be 0 milliseconds");
	    }

	@Test
	public void testGetSecondsGood() {
		  int seconds = Time.getSeconds("12:34:30");
		    assertTrue("The seconds were not calculated properly", seconds == 30);
		
	}

	
	@Test
	public void testGetSecondsBad() {
		assertThrows(
				NumberFormatException.class,
				()-> {Time.getSeconds("12:15:XX");});
		
	}
	
	
	@Test
	public void testGetSecondsBoundary() {
	
	    int secondsAtStartOfMinute = Time.getSeconds("12:34:00");
	    assertEquals("Boundary condition failed at the start of a minute", 0, secondsAtStartOfMinute);


	}
	
	 
	 @Test
	 void testGetTotalMinutesGood() {
	    
	     int minutes = Time.getTotalMinutes("10:25:00");
	     assertEquals(25, minutes, "The minutes were not calculated properly for a good input.");
	 }

	 
	 @Test
	 void testGetTotalMinutesBad() {
		 assertThrows(
				 NumberFormatException.class,
				 ()-> {Time.getTotalMinutes("12:mm:XX");});
	}

		 
	 
	 @Test
	 void testGetTotalMinutesBoundary() {
	   
	     int minutesAtStartOfHour = Time.getTotalMinutes("08:00:00");
	     assertEquals(0, minutesAtStartOfHour, "The minutes were not calculated properly at the start of an hour.");
	 }

	


	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("13:12:15");
		assertEquals(13, hours, "The hours were not calculated properly for a good input.");
	}
	
	
	@Test
	void testGetTotalHoursBad() {
		 assertThrows(
				 NumberFormatException.class,
				 ()-> {Time.getTotalHours("XX-XX-12");});
	}
	
	
	
	@Test
	void testGetTotalHoursBoundary() {
	   
	    int hoursAtStartOfDay = Time.getTotalHours("00:00:00");
	    assertEquals(0, hoursAtStartOfDay, "The hours were not calculated properly at the start of a day.");
	}


	 


}
