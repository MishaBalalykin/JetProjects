import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mytestdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;
        //final String INSERT_INTO = "INSERT INTO dish VALUES(?,?,?,?,?,?,?);";
        final String GET_ALL = "SELECT * FROM dish;";
        //final String DELETE = "DELETE FROM dish where id = ?;";
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            /*preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,1);
            preparedStatement.execute();*/

            preparedStatement = connection.prepareStatement(GET_ALL);

            /*preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "title");
            preparedStatement.setString(3, "description");
            preparedStatement.setFloat(4, 0.2f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("smile.png"));
            preparedStatement.execute();*/
            //////////////////////////////////////
            ResultSet resultSet = preparedStatement.executeQuery();
            //
            //
            //
            //
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String desc = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date date = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("id = " + id);
                System.out.println("title = " + title);
                System.out.println("desc = " + desc);
                System.out.println("rating = " + rating);
                System.out.println("published = " + published);
                System.out.println("date = " + date);
                System.out.println("icon = " + icon.length);

            }
        } catch (SQLException /*| FileNotFoundException*/ e) {
            e.printStackTrace();
        }
    }
}
