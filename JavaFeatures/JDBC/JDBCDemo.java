package JavaFeatures.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Class.forName;


/***
 * W.A.P to understand the usage of JDBC APIs to connect to the database, execute the query and display the result.
 * Things to implement:
 *  a -> Insert 5 student's records (Name, RollNo, CourseName, Score(%)) in the table.
 *  b -> Retrieve and display the details of the students who have scored more than 60% in the course 'JDBC' on the console.
 *  */

public class JDBCDemo {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   // Driver
    private static final String DB_URL = "jdbc:mysql://localhost:3306/demo"; // URL of DB

    // Credentials
    static final String user = "root";
    static final String pass = "Mysql@24";

    public static void main(String[] args){

        try{
            Class.forName(JDBC_DRIVER); // Registering the Driver
            Connection conn = DriverManager.getConnection(DB_URL,user,pass); // Creating conn to DB

            String insertQuery = "Insert into Student\r\n"+"values(?,?,?,?);";  // Creating query

            Student s1 = new Student("abdul khan",101,"JDBC",70);
            Student s2 = new Student("salman khan",102,"JDBC",60);
            Student s3 = new Student("imran khan",103,"JDBC",80);
            Student s4 = new Student("irfan khan",104,"JDBC",50);
            Student s5 = new Student("iqbal khan",105,"JDBC",60);

            //Setting Parameter index for stmts
            PreparedStatement stmt1 = conn.prepareStatement(insertQuery);
            stmt1.setString(1, s1.getName());
            stmt1.setInt(2, s1.getRollNo());
            stmt1.setString(3, s1.getCourseName());
            stmt1.setInt(4, s1.getScore());

            PreparedStatement stmt2 = conn.prepareStatement(insertQuery);
            stmt2.setString(1, s2.getName());
            stmt2.setInt(2, s2.getRollNo());
            stmt2.setString(3, s2.getCourseName());
            stmt2.setInt(4, s2.getScore());

            PreparedStatement stmt3 = conn.prepareStatement(insertQuery);
            stmt3.setString(1, s3.getName());
            stmt3.setInt(2, s3.getRollNo());
            stmt3.setString(3, s3.getCourseName());
            stmt3.setInt(4, s3.getScore());

            PreparedStatement stmt4 = conn.prepareStatement(insertQuery);
            stmt4.setString(1, s4.getName());
            stmt4.setInt(2, s4.getRollNo());
            stmt4.setString(3, s4.getCourseName());
            stmt4.setInt(4, s4.getScore());

            PreparedStatement stmt5 = conn.prepareStatement(insertQuery);
            stmt5.setString(1, s5.getName());
            stmt5.setInt(2, s5.getRollNo());
            stmt5.setString(3, s5.getCourseName());
            stmt5.setInt(4, s5.getScore());

            // Executing all stmt
            stmt1.executeUpdate();
            stmt2.executeUpdate();
            stmt3.executeUpdate();
            stmt4.executeUpdate();
            stmt5.executeUpdate();

            String query = "Select * from Student where score > 60;";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            List<Student> studentList = new ArrayList<>();

            while(rs.next()){
                Student s = new Student();
                s.setName(rs.getString("Name"));
                s.setRollNo(rs.getInt("RollNumber"));
                s.setCourseName(rs.getString("CourseName"));
                s.setScore(rs.getInt("Score"));
                System.out.println(s);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

class Student{
    String name;
    int rollNo;
    String courseName;
    int score;

    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public Student(String name, int rollNo, String courseName, int score){
        this.courseName = courseName;
        this.name = name;
        this.rollNo = rollNo;
        this.score = score;
    }

    @Override
    public String toString(){
        return "[ Name: "+name+" RollNo: "+rollNo+" Courses: "+courseName+" Score: "+score+" ]";
    }
}
