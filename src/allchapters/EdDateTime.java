package allchapters;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EdDateTime {

	public void runIt() {
		
		String eclipseDateTime = "2017-08-21 10:19:21";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime eclipseDay = LocalDateTime.parse(eclipseDateTime,fmt);
		ZonedDateTime zdt = ZonedDateTime.of(eclipseDay, ZoneId.of("US/Pacific"));
		System.out.println("Eclipse 2017: " + zdt);
		ZoneId zidInst = ZoneId.of("US/Pacific");
		Instant pacificInst = zdt.toInstant();
		System.out.println("DST? : " + zidInst.getRules().isDaylightSavings(pacificInst));
		
	}

	public void getTimeZones(String tz) {
		
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		List<String> zoneList = new ArrayList<String>(zoneIds);
		Collections.sort(zoneList);
		if (tz == "ALL") {
			for (String xxx : zoneList) {
				System.out.println("zId: " + xxx);
			}			
		} else {
			for (String xxx : zoneList) {
				if (xxx.contains(tz)) {
					ZoneId zid = ZoneId.of(xxx);
					System.out.println("zId: " + xxx);
					System.out.println(xxx + "zoneRules: " + zid.getRules());
				}
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdDateTime edt = new EdDateTime();
		edt.runIt();
		edt.getTimeZones("US");

	}

}
