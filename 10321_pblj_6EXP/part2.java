

import java.util.*;
class Student 
{
    private String name;
    private double marks;
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() { return name; }
    public double getMarks() { return marks; }
}

public class part2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Samay Sood", 82.5),
            new Student("Samar Sood", 67.0),
            new Student("Pushkar Sood", 91.0),
            new Student("Sarthak Sood", 74.0),
            new Student("Shivakshi Sood", 88.5)
        );
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}

