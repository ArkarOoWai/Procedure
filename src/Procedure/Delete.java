package Procedure;

import java.sql.*;
public class Delete {
	public static Connection con = null;
	static {
	con = MyConnection.getConnection();
	}
	public static void main(String[] args) {
		try {
CallableStatement cst=con.prepareCall(
"call delete_procedure(?)"
);
cst.setInt(1,2);
int result=cst.executeUpdate();	
if(result>0) {
	System.out.println("Successfully Delete");
}
cst.close();
} catch (SQLException e) {
	e.printStackTrace();
	}
        }
}

