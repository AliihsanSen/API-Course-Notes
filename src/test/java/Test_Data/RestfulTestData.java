package Test_Data;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestData {

    public Map<String, String> bookingDatesMethod(String checkin, String checkout) {

        Map<String, String> bookingDatesMap = new HashMap<String, String>();
        bookingDatesMap.put("checkin", checkin);
        bookingDatesMap.put("checkout", checkout);
        return bookingDatesMap;
    }

    public Map<String, Object> expectedDataMethod(String name,String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingDates) {

        Map<String, Object> expectedDataMap = new HashMap<String, Object>();
        expectedDataMap.put("name", name);
        expectedDataMap.put("lastname", lastname);
        expectedDataMap.put("totalprice", totalprice);
        expectedDataMap.put("depositpaid", depositpaid);
        expectedDataMap.put("bookingDates", bookingDates);
        return expectedDataMap;
    }
}
