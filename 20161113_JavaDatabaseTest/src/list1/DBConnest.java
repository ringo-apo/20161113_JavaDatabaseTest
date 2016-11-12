package list1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			System.out.println("接続しました");

			String sql = "SELECT * FROM test.table1";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
            while(rs.next()) {

                // Idデータを取得
                String id = rs.getString("id");
                // Nameデータを取得
                String name = rs.getString("name");
                // Priceデータを取得
                String price = rs.getString("price");
                // mastercolデータを取得
//                String mastercol = rs.getString("new_mastercol");

                // データの表示
                System.out.println("Id;"+" "+id);
                System.out.println("Name;"+" "+name );
                System.out.println("Price;"+" "+price );
//                System.out.println("mastercol;"+" "+mastercol );
            }
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			System.err.println("MySQLエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:"+e.getSQLState());
			System.err.println("エラーメッセージ:"+ e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if(conn!=null){
					conn.close();
					System.out.println("切断しました");
					
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
