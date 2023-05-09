package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.JdbcConfig;
import model.BankAccount;
import model.Transaction;

public class TransactionRepo {
	
	static Connection con = JdbcConfig.getConnection();

	public ArrayList<Transaction> getTransaction(BankAccount ba) {
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		try {
		String sql = "select * from transaction where accountNumber ='" + ba.getAccountNumber() + "' ";
	    PreparedStatement st = con.prepareStatement(sql);
	    ResultSet rs = st.executeQuery();
	    while (rs.next()) {
		    Transaction t = new Transaction();
	    	t.setAccountNumber(rs.getString("accountNumber")); 
	    	t.setTransaction(rs.getString("transaction")); 
            list.add(t);
        }
	    
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public boolean depositAmount(BankAccount ba, int amount) {
		String sql = "INSERT INTO transaction(accountNumber, transaction) values('"
                + ba.getAccountNumber()
                + "', ' Amount " +amount + "credited')";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			int update = st.executeUpdate();
			if (update ==1) {
                return true; 
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
