public class DriverStudent {

    public static void main(String[] args) {
        Student andy = new Student("Andy");
        andy.add("Math", 'C');
        andy.add("English", 'A');
        andy.add("History", 'B');
        andy.add("Geography", 'D');
        System.out.printf("%s has a GPA of %s%n", andy.getName(), andy.getGPA());
        System.out.println("GPA is obtained from the following objects:");
        for (String str : andy.getSubjects()) {
            System.out.println(str);
        }
    }
}
