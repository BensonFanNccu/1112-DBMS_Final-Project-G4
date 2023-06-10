package controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UserManager {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/db_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "benson";
	static final String PASS = "123456789";
	
	private Connection conn;

	public UserManager() {
		mysql_connect();
	}

	public void mysql_connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find driver");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String account, String password) {
		try {
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM `user` "
														 + "WHERE Account = ? "
														 + "AND Password = ?");
			stat.setString(1, account);
			stat.setString(2, password);

			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String register(String account, String email, String password, String repassword) {
		try {
			// Check userName duplication
			PreparedStatement stat = conn.prepareStatement("SELECT * "
														 + "FROM `user` WHERE Account = ?");
			stat.setString(1, account);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				return "此名稱已被使用";
			}

			// Check email duplication
			stat = conn.prepareStatement("SELECT * "
									   + "FROM `user` WHERE Email = ?");
			stat.setString(1, email);
			rs = stat.executeQuery();
			if (rs.next()) {
				return "此Email已被使用";
			}
			
			if(!password.equals(repassword)) {
				return "密碼前後不一致";
			}

			// Insert values
			stat = conn.prepareStatement("INSERT INTO user(Account, Email, Password)"
									   + "VALUES (?, ?, ?);");
			stat.setString(1, account);
			stat.setString(2, email);
			stat.setString(3, password);
			stat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
		return "註冊成功";
	}
	
	public void sendVerification(String email, String code) {
		String account = "restaurantchooserdbms@gmail.com";
		String password = "hljuiqiciufrhjfp";
		
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(account, password);
                    }
                }
        );
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("restaurantchooserdbms@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("fbi0826@gmail.com"));
            message.setSubject(code + "是您的驗證碼");
            message.setText("感謝您使用餐廳選擇器。\n"
            			  + "輸入驗證碼，即通過電子信箱完成身分確認\n"
            			  + code + "是您的驗證碼");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
	public int getUserId(String account) {
		try {
			PreparedStatement stat = conn.prepareStatement("SELECT UserID "
														 + "FROM `user` "
														 + "WHERE Account = ?");
			stat.setString(1, account);
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				return Integer.parseInt(rs.getString("UserID"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean writeReview(String uid, String rid, String comment, String star) {
		try {
			PreparedStatement stat = conn.prepareStatement("INSERT INTO Review(UserID, RestID, Comment, Stars)"
														 + " VALUES(?, ?, ?, ?)");
			stat.setString(1, uid);
			stat.setString(2, rid);
			stat.setString(3, comment);
			stat.setString(4, star);
			stat.executeUpdate();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addFavorite(String uid, String rid) {
		try {
			PreparedStatement stat = conn.prepareStatement("Insert into Collection (UserID, RestID)"
														 + "Values(?,?)");
			stat.setString(1, uid);
			stat.setString(2, rid);
			stat.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> getFavorite(String uid){
		ArrayList<String> res = new ArrayList<String>();
		int count = 0;
		try {
			PreparedStatement stat = conn.prepareStatement("SELECT r.NAME "
														 + "FROM restaurant AS r, collection AS c "
														 + "WHERE c.UserID = ? "
														 + "AND c.RestID = r.RestID");
			stat.setString(1, uid);
			ResultSet rs = stat.executeQuery();
			
			while(rs.next() && count < 3) {
				res.add(rs.getString("Name"));
				count++;
			}
			return res;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
