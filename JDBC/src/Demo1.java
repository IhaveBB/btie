/*
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");
        //连接
        Connection connection = dataSource.getConnection();
        //增加数据
        String sql = "INSERT INTO student VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        System.out.println("sql "+ statement);
        //删除数据
        String sql1 = "DELETE FROM student WHERE id = ?";
        PreparedStatement statement1 = connection.prepareStatement(sql1);
        statement1.setInt(1, id);
        //修改数据
        String sql3 = "UPDATE student SET name = ? WHERE id = ?";
        PreparedStatement statement3 = connection.prepareStatement(sql3);
        statement3.setString(1, name);

        //查询数据
        String sql2 = "SELECT * FROM student";
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        ResultSet resultSet = statement2.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //关闭资源
        statement.close();
        connection.close();
    }
}
*/

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

class Demo1{
    public static void main(String[] args) throws SQLException {
        //连接数据库
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/java109?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");
        //连接
        Connection connection = dataSource.getConnection();

        //1. 新增貂蝉同学的借阅记录：诗经，从2019年9月25日17:50到2019年10月25日17:50
        String sql = "insert into t_borrow(id,name,book_name,borrow_date,return_date) values(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);
        statement.setString(2, "貂蝉");
        statement.setString(3, "诗经");
        statement.setDate(4, Date.valueOf("2019-09-25"));
        statement.setDate(5, Date.valueOf("2019-10-25"));
        statement.executeUpdate();

        //2. 查询计算机分类下的图书借阅信息
        sql = "select * from t_borrow where book_name like ?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, "%计算机%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("book_name"));
        }

        //3. 修改图书《深入理解Java虚拟机》的价格为61.20
        sql = "update t_book set price=? where book_name=?";
        statement = connection.prepareStatement(sql);
        statement.setDouble(1, 61.20);
        statement.setString(2, "深入理解Java虚拟机");
        statement.executeUpdate();

        //4. 删除id最大的一条借阅记录
        sql = "delete from t_borrow where id=?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);
        statement.executeUpdate();

    }
}