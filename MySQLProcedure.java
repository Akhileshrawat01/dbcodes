import java.sql.*;
import java.util.*;

public class MySQLProcedure {
    public static void main(String[] args) {
        try throws Exception {
        	  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        	  final String DB_URL = "jdbc:mysql://localhost:3306/testprac";
        	final String USER = "root";
        	   final String PASS = "tiamo"; 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement sm = conn.createStatement();
            int ch;
            Scanner s = new Scanner(System.in);

            do {
                System.out.println("Enter Choice \n 1.Insert \n 2.Select \n3.Update \n 4.Delete \n 5.Exit ");
                ch = s.nextInt();
                switch (ch) {
                    case 1:
                        String sql = "Insert into stud values ('Ankita' ,1)";
                        sm.executeUpdate(sql);
                        System.out.println("Record is Inserted");
                        break;
                    case 2:
                        sql = "SELECT * FROM stud";
                        ResultSet rs = sm.executeQuery(sql);
                        while (rs.next()) {
                            String name1 = rs.getString("name");
                            int rno1 = rs.getInt("roll_no");
                            System.out.print("name " + name1);
                            System.out.println(", Age: " + rno1);
                        }
                        break;
                    case 3:
                        sql = "update stud set name='Mona' where name='Ankita' ";
                        sm.executeUpdate(sql);
                        System.out.println("Record is updated");
                        break;
                    case 4:
                        sql = "delete from stud where roll_no=1";
                        sm.executeUpdate(sql);
                        System.out.println("Record is deleted");
                        break;
                }
            } while (ch < 5);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

