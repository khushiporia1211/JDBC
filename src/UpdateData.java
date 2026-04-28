import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {


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
                String query = String.format("UPDATE students SET age = '%d' WHERE id = %d",28,6);
                int rs= statement.executeUpdate(query);
                if(rs>0){
                    System.out.println("Data Updated Successfully");
                }else{
                    System.out.println("Data Not Updated ");
                }

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

