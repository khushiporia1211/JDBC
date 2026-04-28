import java.sql.*;
public class Main{
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String username="root";
    private static final String password="your password";
    public static void main(String[] args)  {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
       }catch (ClassNotFoundException e ){
           System.out.println(e.getMessage());
       }
       try{
           Connection connection = DriverManager.getConnection(url,username,password);
           Statement statement = connection.createStatement();

           String query = String.format("INSERT INTO students(name,age,marks) VALUES('%s'" +
                   "" + ",%d,%f)","Maya",24,67.8);
           int rs= statement.executeUpdate(query);
           if(rs>0){
               System.out.println("Data Inserted Successfully");
           }else{
               System.out.println("Data Not Inserted");
           }

    }catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }
}
