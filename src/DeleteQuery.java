import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String username="root";
    private static final String password="k2H@ushi12";
    public static void main(String[] args)  {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e ){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM students WHERE id = %d",5);
            int rs= statement.executeUpdate(query);
            if(rs>0){
                System.out.println("Data Deleted Successfully");
            }else{
                System.out.println("Data Not Deleted ");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
