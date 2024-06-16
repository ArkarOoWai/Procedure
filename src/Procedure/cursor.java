package Procedure;

import java.sql.*;
public class cursor {
	public static Connection con = null;
	static {
	con = MyConnection.getConnection();
	}
	public static void main(String[] args) {
		try {
CallableStatement cst=con.prepareCall(
"call ojt14db.cursor_procedure(?,?)");
cst.setDouble(1, 100.00);
cst.registerOutParameter(2, Types.VARCHAR);
cst.setString(2,"");
cst.executeUpdate();
String result = cst.getString(2);

System.out.println("result : "+result);
	cst.close();
} catch (SQLException e) {
	e.printStackTrace();
}
}
}

