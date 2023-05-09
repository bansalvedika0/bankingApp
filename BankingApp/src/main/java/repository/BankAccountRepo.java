package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.JdbcConfig;
import model.BankAccount;

public class BankAccountRepo {
	
	static Connection con = JdbcConfig.getConnection();
    public boolean createAccount(BankAccount bankAccount)
    {
        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO account(name,username,password,accountNumber, aadhar,pan,postal,dob,balance) values('"
                  + bankAccount.getName() 
                  + "', '" + bankAccount.getUsername()
                  + "', '" + bankAccount.getPassword()
                  + "', '" + bankAccount.getAccountNumber()
                  + "', '" + bankAccount.getAadhar()
                  + "', '" + bankAccount.getPan()
                  + "', '" + bankAccount.getPostalCode()
                  + "', '" + bankAccount.getDob()
                  + "', '" + bankAccount.getBalance()
                  + "')";
 
            if (st.executeUpdate(sql) == 1) {
                return true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
	public BankAccount login(String username, String password) {
		BankAccount ba = null;
		try {
		String sql = "select * from account where username='" + username + "' and password=" + password;
	    PreparedStatement st = con.prepareStatement(sql);
	    ResultSet rs = st.executeQuery();
	    ba = new BankAccount();
	    if (rs.next()) {
	    	ba.setBalance(rs.getInt("balance")); 
	    	ba.setName(rs.getString("name")); 
            ba.setUsername(username);
            ba.setPassword(password);
            ba.setAccountNumber(rs.getString("accountNumber"));
            return ba;
        }
	    
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ba;
	}
	public int getBalance(String username) {
		String sql = "Select balance from account where username = '"+ username + "'";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
                return rs.getInt("balance"); 
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public boolean depositAmount(BankAccount ba, int amount) {
		String sql = "update account set balance = "+amount+ " where  accountNumber = '"+ ba.getAccountNumber() + "'";
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
