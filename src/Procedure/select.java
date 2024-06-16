package Procedure;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class select {
	public static Connection con = null;
	static {
	con = MyConnection.getConnection();
	}
	public static void main(String[] args) {
List<customerget> lstCust=new ArrayList<customerget>();
		try {
CallableStatement cst=con.prepareCall(
"call select_procedure()"
);
ResultSet rs=cst.executeQuery();
while(rs.next()) {
	customerget cust=new customerget();
	cust.setId(rs.getInt(1));
	cust.setName(rs.getString(2));
	cust.setAddress(rs.getString(3));
	cust.setSalary(rs.getDouble(4));
	lstCust.add(cust);
	}
	cst.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	for (customerget customer : lstCust) {
	System.out.println(customer.getId()+"   "+customer.getName()+"   "+customer.getAddress()+"   "+customer.getSalary());
	}
	}
}
