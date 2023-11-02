import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<String> subject;
    private ArrayList<Character> grade;

    public Student(String n) {
        name = n;
        subject = new ArrayList<String>();
        grade = new ArrayList<Character>();
    }

    public String getName() {
        return name;
    }

    public void add(String s, Character c) {
        subject.add(s);
        grade.add(c);
    }

    public ArrayList<String> getSubjects() {
        return subject;
    }

    public double getGPA() {
        double totalPoints = 0.0;
        for (char g : grade) {
            switch (g) {
                case 'A':
                    totalPoints += 4.0;
                    break;
                case 'B':
                    totalPoints += 3.0;
                    break;
                case 'C':
                    totalPoints += 2.0;
                    break;
                case 'D':
                    totalPoints += 1.0;
                    break;
                case 'F':
                    totalPoints += 0.0;
                    break;
            }
        }
        return totalPoints / grade.size();
    }


}
