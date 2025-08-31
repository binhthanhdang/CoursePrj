package edu.iuh.fit.se;

import java.util.Scanner;

 /**
 * @description: My Introduction
 * @author: Dang Thanh Binh
 * @version: 1.0
 * @created: Aug 31, 2025 11:38:30 AM
 */
public class TestCourse {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(100);
        initData(courseList);

        while (true) {
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Xóa khóa học");
            System.out.println("3. Tìm khóa học theo ID");
            System.out.println("4. Tìm khóa học theo tên");
            System.out.println("5. Tìm khóa học theo khoa");
            System.out.println("6. Sắp xếp khóa học theo tên");
            System.out.println("7. Tìm khóa học có nhiều tín chỉ nhất");
            System.out.println("8. Tìm khoa có nhiều khóa học nhất");
            System.out.println("9. Xuất danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên khóa học: ");
                    String title = sc.nextLine();
                    System.out.print("Nhập khoa: ");
                    String dept = sc.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int credit = Integer.parseInt(sc.nextLine());
                    Course c = new Course( id, title, credit, dept);
                    courseList.addCourse(c);
                    break;
                case 2:
                    System.out.print("Nhập ID muốn xóa: ");
                    String delId = sc.nextLine();
                    courseList.removeCourse(delId);
                    break;
                case 3:
                    System.out.print("Nhập ID cần tìm: ");
                    String findId = sc.nextLine();
                    Course found = courseList.searchCourseById(findId);
                    if (found != null) {
                        printHeader();
                        printCourse(found);
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên khóa học cần tìm: ");
                    String findTitle = sc.nextLine();
                    Course[] foundByTitle = courseList.searchCourse(findTitle);
                    if (foundByTitle != null && foundByTitle.length > 0) {
                        printHeader();
                        for (Course course : foundByTitle) {
                            printCourse(course);
                        }
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 5:
                    System.out.print("Nhập khoa cần tìm: ");
                    String findDept = sc.nextLine();
                    Course[] foundByDept = courseList.searchCourseByDepartment(findDept);
                    if (foundByDept != null && foundByDept.length > 0) {
                        printHeader();
                        for (Course course : foundByDept) {
                            printCourse(course);
                        }
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 6:
                    Course[] sorted = courseList.sortCoursesByTitle();
                    printHeader();
                    for (Course course : sorted) {
                        printCourse(course);
                    }
                    break;
                case 7:
                    Course[] maxCreditCourses = courseList.findMaxCreditCourse();
                    if (maxCreditCourses != null && maxCreditCourses.length > 0) {
                        printHeader();
                        for (Course course : maxCreditCourses) {
                            printCourse(course);
                        }
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 8:
                    String maxDept = courseList.findDepartmentWithMostCourses();
                    if (maxDept != null) {
                        System.out.println("Khoa có nhiều khóa học: " + maxDept);
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 9:
                    Course[] allCourses = courseList.getCourses();
                    if (allCourses.length > 0) {
                        printHeader();
                        for (Course course : allCourses) {
                            printCourse(course);
                        }
                    } else {
                        System.out.println("Danh sách trống");
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    sc.close();
                    return;
                default:
                    System.out.println("Không tồn tại lựa chọn này");
            }
        }
    }

    private static void printHeader() {
        System.out.printf("%-10s %-30s %-20s %-10s\n", "Course ID", "Title", "Department", "Credits");
        System.out.println("--------------------------------------------------------------------------");
    }

    private static void printCourse(Course c) {
        System.out.printf("%-10s %-30s %-20s %-10d\n", c.getId(), c.getTitle(), c.getDepartment(), c.getCredit());
    }

    private static void initData(CourseList courseList) {
        try {
            courseList.addCourse(new Course("IT101", "Programming Fundamentals", 3, "Information Technology"));
            courseList.addCourse(new Course("IT202", "Web Development", 4, "Information Technology"));

            courseList.addCourse(new Course("BUS101", "Principles of Management", 3, "Business"));
            courseList.addCourse(new Course("BUS202", "Marketing Basics", 3, "Business"));

            courseList.addCourse(new Course("BIO101", "General Biology", 4, "Biology"));
            courseList.addCourse(new Course("BIO202", "Genetics", 3, "Biology"));

            courseList.addCourse(new Course("CHEM101", "General Chemistry", 4, "Chemistry"));
            courseList.addCourse(new Course("CHEM202", "Organic Chemistry", 4, "Chemistry"));
            
            courseList.addCourse(new Course("ART101", "Introduction to Painting", 2, "Arts"));
            courseList.addCourse(new Course("ART202", "History of Arts", 3, "Arts"));
        } catch (Exception e) {
            System.err.println("Error initializing data: " + e.getMessage());
        }
    }


}
