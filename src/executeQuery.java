import java.sql.*;
public class executeQuery {

        private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        private static final String username="root";
        private static final String password="your paasword";
        public static void main(String[] args)  {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e ){
                System.out.println(e.getMessage());
            }
            try{
                Connection connection = DriverManager.getConnection(url,username,password);
                Statement statement = connection.createStatement();
           String query = "SELECT* FROM students";
           ResultSet rs = statement.executeQuery(query);

           while(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               int age = rs.getInt("age");
               double marks =rs.getDouble("marks");
               System.out.println("ID: "+id);
               System.out.println("NAME: "+name);
               System.out.println("AGE: "+age);
               System.out.println("MARKS: "+marks);
           }

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

