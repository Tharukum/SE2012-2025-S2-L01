import java.util.Scanner;

public class Marks {
    Scanner scan = new Scanner(System.in);
    int[] marks = new int[3];
    int n;
    int sub1 = 0;
    int sub2 = 0;
    int sub3 = 0;

    public static void main(String[] args) {
        int c = 0;
        Marks app = new Marks();

        System.out.println("Enter the number of Students:");
        app.n = app.scan.nextInt();
        while (c < app.n) {
            System.out.println("Enter StudentID");
            int studentID = app.scan.nextInt();

            if (studentID > 0 && studentID <= app.n) {
                c++;
                app.key(studentID);
            } else {
                System.out.printf("Enter Valid StudentID between 1 and %d\n", app.n);
            }
        }

        app.scan.close();
    }

    public void grade(int studentID) {
        System.out.println("\nGrades for Student " + studentID + ":");
        System.out.println("Subject\tMarks\tGrade");
        for (int i = 0; i < 3; i++) {
            String grade;
            if (marks[i] >= 90) grade = "A";
            else if (marks[i] >= 80) grade = "B";
            else if (marks[i] >= 70) grade = "C";
            else if (marks[i] >= 60) grade = "D";
            else grade = "Fail";
            System.out.printf("%d\t%d\t%s\n", i+1, marks[i], grade);
        }
    }

    public void key(int studentID) {
        while (true) {
            System.out.println("\n--- Menu for Student " + studentID + " ---");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student mark");
            System.out.println("3. Get the average for a subject");
            System.out.println("4. Get the average for a student");
            System.out.println("5. Get the total mark of a student");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int key = scan.nextInt();

            if (key == 1) {
                add(studentID);
                grade(studentID);
            } else if (key == 2) {
                System.out.println("Enter SubjectID (1-3):");
                int subjectID = scan.nextInt();

                if (subjectID > 0 && subjectID <= 3) {
                    update(studentID, subjectID);
                    grade(studentID);
                } else {
                    System.out.println("Invalid SubjectID! Enter 1, 2, or 3.");
                }
            } else if (key == 3) {
                average_s(studentID);
            } else if (key == 4) {
                average(studentID);
            } else if (key == 5) {
                total(studentID);
            } else if (key == 6) {
                grade(studentID);
                System.out.println("Exiting menu for Student " + studentID);
                break;
            } else {
                System.out.println("Invalid option! Enter 1-6.");
            }
        }
    }

    public void add(int studentID) {
        int c = 0;

        while (c < 3) {
            System.out.println("Enter SubjectID (1-3):");
            int sub = scan.nextInt();

            if (sub > 0 && sub < 4) {
                boolean validMark = false;
                while (!validMark) {
                    System.out.println("Enter Marks (0-100):");
                    int mark = scan.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[sub - 1] = mark;

                        if (sub == 1) {
                            sub1 += mark;
                        } else if (sub == 2) {
                            sub2 += mark;
                        } else if (sub == 3) {
                            sub3 += mark;
                        }
                        c++;
                        validMark = true;
                    } else {
                        System.out.println("Invalid marks! Enter 0-100.");
                    }
                }
            } else {
                System.out.println("Invalid SubjectID! Enter 1, 2, or 3.");
            }
        }
    }

    public void update(int studentID, int subjectID) {
        boolean validMark = false;
        while (!validMark) {
            System.out.println("Enter new mark (0-100):");
            int newMark = scan.nextInt();

            if (newMark >= 0 && newMark <= 100) {
                marks[subjectID - 1] = newMark;
                System.out.println("Mark updated successfully!");
                validMark = true;
            } else {
                System.out.println("Invalid marks! Enter 0-100.");
            }
        }
    }

    public void average_s(int studentID) {
        System.out.println("Enter SubjectID (1-3):");
        int subjectID = scan.nextInt();

        if (subjectID == 1) {
            float Avg1 = (float) sub1 / n;
            System.out.printf("Subject %d Average: %.2f\n", subjectID, Avg1);
        } else if (subjectID == 2) {
            float Avg2 = (float) sub2 / n;
            System.out.printf("Subject %d Average: %.2f\n", subjectID, Avg2);
        } else if (subjectID == 3) {
            float Avg3 = (float) sub3 / n;
            System.out.printf("Subject %d Average: %.2f\n", subjectID, Avg3);
        } else {
            System.out.println("Invalid SubjectID! Enter 1, 2, or 3.");
        }
    }

    public void average(int studentID) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += marks[i];
        }
        float stuAvg = (float) sum / 3;
        System.out.printf("Student %d Average: %.2f\n", studentID, stuAvg);
    }

    public void total(int studentID) {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += marks[i];
        }
        System.out.printf("Student %d Total: %d\n", studentID, total);
    }
}