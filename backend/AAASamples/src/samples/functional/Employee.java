package org.example;

public class Employee {

    long eid;
    String name;
    int age;
    double salary;
    String designation;
    String gender;
    String department;

    public Employee(long eid, String name, int age, double salary, String designation, String gender, String department) {
        this.eid = eid;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
        this.gender = gender;
        this.department = department;
    }

    public long getEid() {
        return eid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "eid=" + eid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                "\n";
    }
}
