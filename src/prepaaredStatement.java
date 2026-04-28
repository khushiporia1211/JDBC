import java.sql.*;

public class prepaaredStatement {
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
            String query = "INSERT INTO students(name,age,marks) VALUES(?,?,?)";
            PreparedStatement prestatement = connection.prepareStatement(query);
            prestatement.setString(1,"Mohini");
            prestatement.setInt(2,30);
            prestatement.setDouble(3,67.8);


            int rs= prestatement.executeUpdate();
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
