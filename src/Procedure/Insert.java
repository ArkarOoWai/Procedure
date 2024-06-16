package Procedure;

import java.sql.*;
public class Insert {
	public static Connection con = null;
	static {
	con = MyConnection.getConnection();
	}
	public static void main(String[] args) {
	try {
CallableStatement cst=con.prepareCall(
"call insert_procedure(?,?,?,?)"
);
cst.setInt(1,11);
cst.setString(2, "Dapu");
cst.setString(3,"New Dali");
cst.setDouble(4, 4000.00);
int result=cst.executeUpdate();
if(result>0) {
	System.out.println("Successfully Insert");
	}
	cst.close();
} catch (SQLException e) {			e.printStackTrace();
		}	
	}
}

