
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Solution {

	@SuppressWarnings("unused")
	public int solution(String S) {

		Vector<Meeting> meeting_list = new Vector<Meeting>();
		Vector<Integer> sleep_start_time_list = new Vector<Integer>();
		Vector<Integer> sleep_end_time_list = new Vector<Integer>();
		Vector<Integer> can_sleep_time_list = new Vector<Integer>();
		// Vector<Person> personlist= new Vector<Person>();
		StringTokenizer st1;
		StringTokenizer st2;
		StringTokenizer st3;
		StringTokenizer st4;

		String meeting_text = "";
		String meeting_day = "";
		String meeting_hours = "";
		String meeting_start_time = "";
		String meeting_finish_time = "";

		int one_day_as_hour = 24;// enum
		int one_hour_as_minute = 60;// enum

		Business_man business_man = new Business_man();

		int maximum_sleep_time = 0;

		try {
			meeting_list_parser(S, meeting_list);
			Collections.sort(meeting_list, new Meeting_Comparator());

			S = "";
			st1 = null;
			st2 = null;
			st3 = null;
			st4 = null;

			business_man.first_name = "James";
			business_man.working_start_time.day = 0;
			business_man.working_start_time.hour = 0;
			business_man.working_start_time.minute = 0;
			business_man.working_finish_time.day = 6;
			business_man.working_finish_time.hour = 24;
			business_man.working_finish_time.minute = 0;

			sleep_start_time_list.add(business_man.working_start_time.day * one_day_as_hour * one_hour_as_minute
					+ business_man.working_start_time.hour * one_hour_as_minute
					+ business_man.working_start_time.minute);

			set_sleep_start_time_list_from_list(meeting_list, sleep_start_time_list);

			set_sleep_end_time_list_from_list(meeting_list, sleep_end_time_list);

			sleep_end_time_list.add(business_man.working_finish_time.day * one_day_as_hour * one_hour_as_minute
					+ business_man.working_finish_time.hour * one_hour_as_minute
					+ business_man.working_finish_time.minute);

			set_can_sleep_time_list(sleep_start_time_list, sleep_end_time_list, can_sleep_time_list);
			maximum_sleep_time = find_maximum_sleep_time(can_sleep_time_list, maximum_sleep_time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maximum_sleep_time;
	}

	public int find_maximum_sleep_time(Vector<Integer> can_sleep_time_list, int maximum_sleep_time) {
		for (int i = 0; i < can_sleep_time_list.size(); i++) {
			if (maximum_sleep_time < can_sleep_time_list.elementAt(i)) {
				maximum_sleep_time = can_sleep_time_list.elementAt(i);
			}
		}
		return maximum_sleep_time;
	}

	public void set_can_sleep_time_list(Vector<Integer> sleep_start_time_list, Vector<Integer> sleep_end_time_list,
			Vector<Integer> can_sleep_time_list) {
		for (int i = 0; i < sleep_start_time_list.size(); i++) {
			Sleep sleep = new Sleep();
			set_sleep_start(sleep_start_time_list, i, sleep);
			set_sleep_end(sleep_end_time_list, i, sleep);
			sleep.time_long = sleep.end - sleep.start;
			can_sleep_time_list.add(sleep.time_long);
		}
	}

	public void set_sleep_start(Vector<Integer> sleep_start_time_list, int i, Sleep sleep) {
		if (sleep_start_time_list != null) {
			if (sleep_start_time_list.elementAt(i) != null) {
				sleep.start = sleep_start_time_list.elementAt(i);
			} else {
				// System.out.println("null3");
				return;
			}
			sleep.start = sleep_start_time_list.elementAt(i);
		} else {
			// System.out.println("null4");
			return;
		}
	}

	public void set_sleep_end(Vector<Integer> sleep_end_time_list, int i, Sleep sleep) {
		if (sleep_end_time_list != null) {
			if (sleep_end_time_list.elementAt(i) != null) {
				sleep.end = sleep_end_time_list.elementAt(i);
			} else {
				// System.out.println("null1");
				return;
			}
		} else {
			// System.out.println("null2");
			return;
		}
	}

	public void set_sleep_end_time_list_from_list(Vector<Meeting> meeting_list, Vector<Integer> sleep_end_time_list) {
		for (int i = 0; i < meeting_list.size(); i++) {
			Meeting meeting = meeting_list.get(i);
			sleep_end_time_list.add(meeting.start_time.oncelik);
		}
	}

	public void set_sleep_start_time_list_from_list(Vector<Meeting> meeting_list,
			Vector<Integer> sleep_start_time_list) {
		for (int i = 0; i < meeting_list.size(); i++) {
			Meeting meeting2 = meeting_list.get(i);
			if (meeting2 != null) {
				sleep_start_time_list.add(meeting2.finish_time.oncelik);
			} else {
				// System.out.println("i:" + i + "meeting_list.size():" + meeting_list.size());
				return;
			}
		}
	}

	public void meeting_list_parser(String S, Vector<Meeting> meeting_list) {
		StringTokenizer st1;
		st1 = new StringTokenizer(S, "\n");// meeting_text
		while (st1.hasMoreTokens()) {
			Meeting meeting1 = meeting_parser(st1);
			meeting_list.add(meeting1);
		}
	}

	public Meeting meeting_parser(StringTokenizer st1) {
		StringTokenizer st2;
		StringTokenizer st3;
		StringTokenizer st4;
		String meeting_text;
		String meeting_day;
		String meeting_hours;
		String meeting_start_time;
		String meeting_finish_time;
		Meeting meeting1 = new Meeting();
		meeting_text = st1.nextToken();
		st2 = new StringTokenizer(meeting_text, " ");// meeting day and meeting hours
		meeting_day = st2.nextToken();
		meeting_hours = st2.nextToken();
		st3 = new StringTokenizer(meeting_hours, "-");// meeting start time and meeting finish time
		meeting_start_time = st3.nextToken();
		time_parser(meeting_start_time, meeting1.start_time);
		meeting_finish_time = st3.nextToken();
		time_parser(meeting_finish_time, meeting1.finish_time);
		st4 = new StringTokenizer(meeting_finish_time, ":");// hour and minute
		meeting1.finish_time.hour = Integer.parseInt(st4.nextToken());
		meeting1.finish_time.minute = Integer.parseInt(st4.nextToken());

		meetinf_day_parser(meeting_day, meeting1);

		meeting1.start_time.oncelik = meeting1.start_time.saati_dakikaya_cevir();
		meeting1.finish_time.oncelik = meeting1.finish_time.saati_dakikaya_cevir();
		return meeting1;
	}

	public void time_parser(String time_string, Time time) {
		StringTokenizer st4;
		st4 = new StringTokenizer(time_string, ":");// hour and minute

		time.hour = Integer.parseInt(st4.nextToken());
		time.minute = Integer.parseInt(st4.nextToken());
	}

	public void meetinf_day_parser(String meeting_day, Meeting meeting1) {
		if (meeting_day.equals("Mon")) {
			meeting1.start_time.day = meeting1.finish_time.day = 0;
		}
		if (meeting_day.equals("Tue")) {
			meeting1.start_time.day = meeting1.finish_time.day = 1;
		}
		if (meeting_day.equals("Wed")) {
			meeting1.start_time.day = meeting1.finish_time.day = 2;
		}
		if (meeting_day.equals("Thu")) {
			meeting1.start_time.day = meeting1.finish_time.day = 3;
		}
		if (meeting_day.equals("Fri")) {
			meeting1.start_time.day = meeting1.finish_time.day = 4;
		}
		if (meeting_day.equals("Sat")) {
			meeting1.start_time.day = meeting1.finish_time.day = 5;
		}
		if (meeting_day.equals("Sun")) {
			meeting1.start_time.day = meeting1.finish_time.day = 6;
		}
	}

}