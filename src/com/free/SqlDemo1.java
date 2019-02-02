package com.free;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class SqlDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			try {
				// 1 加载驱动
				DriverManager.registerDriver(new Driver());
				// 2 获取连接
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test??useUnicode=true&characterEncoding=utf8", "root", "526666zf");
				// 3 创建执行 sql 语句对象，并执行
				String sql="select * from user";
				Statement stmt = (Statement) conn.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql);
				while(resultSet.next()) {
					int id = resultSet.getInt("id");
					String username = resultSet.getString("username");
					System.out.println(id+username);
				}
				// 释放资源
				resultSet.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

}
