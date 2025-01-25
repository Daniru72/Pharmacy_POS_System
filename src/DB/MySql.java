package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MySql {

    static String userDirectory = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath()
            .toString();

    public static Connection connection;
    static String host = "";
    static String username = "";
    static String databseName = "";
    static String password = "";

    static {

        JSONParser parser = new JSONParser();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            userDirectory = FileSystems.getDefault()
                    .getPath("")
                    .toAbsolutePath()
                    .toString();
            String url = userDirectory + "\\lib\\database.json";

            Object obj = parser.parse(new FileReader(url));
            JSONObject j = (JSONObject) obj;
            host = String.valueOf(j.get("host"));
            databseName = String.valueOf(j.get("databaseName"));
            username = String.valueOf(j.get("username"));
            password = String.valueOf(j.get("password"));
            connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + databseName, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet execute(String query) throws Exception {

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        if (query.startsWith("SELECT")) {
            ResultSet r = statement.executeQuery(query);
            return r;
        } else {
            int result = statement.executeUpdate(query);
            return null;

        }

    }


}
