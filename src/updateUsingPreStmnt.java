import java.sql.*;

public class updateUsingPreStmnt {
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
            String query = "UPDATE students SET marks = ? WHERE id = ?";
            PreparedStatement prestatement = connection.prepareStatement(query);
            prestatement.setDouble(1,99);
            prestatement.setInt(2,7);


            int rs= prestatement.executeUpdate();
            if(rs>0){
                System.out.println("Data Updated Successfully");
            }else{
                System.out.println("Data not Updated");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
