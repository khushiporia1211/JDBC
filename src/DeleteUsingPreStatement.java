import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUsingPreStatement {
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
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement prestatement = connection.prepareStatement(query);

            prestatement.setInt(1,7);


            int rs= prestatement.executeUpdate();
            if(rs>0){
                System.out.println("Data Deleted Successfully");
            }else{
                System.out.println("Data not Deleted");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
