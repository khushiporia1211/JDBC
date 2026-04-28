import java.sql.*;

public class retrieveDataByPreStatment {
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
            String query = "SELECT marks FROM students WHERE id = ?";
            PreparedStatement prestatement = connection.prepareStatement(query);
            prestatement.setInt(1,1);


            ResultSet rs= prestatement.executeQuery();
            if(rs.next()){
                Double marks = rs.getDouble("marks");
                System.out.println("Marks: "+marks);
            }else{
                System.out.println("Marks not found");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
