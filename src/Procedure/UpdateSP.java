package Procedure;
import java.sql.*;

public class UpdateSP {
	public static Connection con = null;
	static {
	con = MyConnection.getConnection();
	}
	public static void main(String[] args) {
		try {
CallableStatement cst=con.prepareCall("call update_procedure(?,?)");
cst.setInt(1,3);
cst.setString(2,"New Dali");
int result=cst.executeUpdate();
if(result>0) {
	System.out.println("Successfully Update");
}
cst.close();
} catch (SQLException e) {
	e.printStackTrace();
	}		
         }
}


