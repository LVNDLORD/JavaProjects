package RosterTable;

import java.util.ArrayList;

public class RosterTable {

    public static void main(String[] args) {
        int days = 3;
        // ArrayList of ArrayLists
        ArrayList<ArrayList<String>> roster = new ArrayList<>(days);
        // each sub-arrayList (days on duty)
        ArrayList<String> day1 = new ArrayList<String>();
        ArrayList<String> day2 = new ArrayList<String>();
        ArrayList<String> day3 = new ArrayList<String>();
        day1.add("Alice");
        day1.add("Bob");
        roster.add(day1);
        day2.add("Alice");
        day2.add("Sam");
        day2.add("Mike");
        roster.add(day2);
        day3.add("Ray");
        day3.add("Sam");
        roster.add(day3);
        getDays(roster, "Alice");
        getDays(roster, "Sam");

    }

    public static void getDays(ArrayList<ArrayList<String>> rosterTable, String name) {
        for (ArrayList<String> arrList : rosterTable) { // looping over each sub array of the rosterTable
            for (String str : arrList) {
                if (str.contentEquals(name)) {
                    System.out.println(name + " is on duty on day " + (rosterTable.indexOf(arrList) + 1));
                }
            }
        }

    }
}

