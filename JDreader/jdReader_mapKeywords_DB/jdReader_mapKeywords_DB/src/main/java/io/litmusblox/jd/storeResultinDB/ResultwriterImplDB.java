package io.litmusblox.jd.storeResultinDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultwriterImplDB implements Resultwriter {
	
public void storeResult(String jdcontent, String resultCommaseperated) 
	{
			Connection connection= null;
		
			try {
				// LOAD THE DRIVER
				Class.forName("com.mysql.cj.jdbc.Driver");
				 connection = DriverManager.getConnection(
						"jdbc:mysql://jmdb-predictor-dev.cptvjl3vuwqy.ap-south-1.rds.amazonaws.com/role_predictor_dev",
						"jmlabsuser", "Testpass10");
				// here sonoo is database litmusbox_wordcount, root is username and
				// password is not set
				//String query = "INSERT INTO `Manufacturing_Keywords` (Resume_Title,KeySkills) VALUE ('"+filename+"','"+resultCommaseperated+"')";
				// create the java statement
				Statement st = connection.createStatement();

				// execute the query, and get a java resultset
				//ResultSet rs = st.executeQuery(query);
				//int rs = st.executeUpdate("INSERT INTO `Manufacturing_Keywords`(Resume_Title,KeySkills) VALUE ('"+filename+"','"+resultCommaseperated+"')");
				//int rs = st.executeUpdate("INSERT INTO `Sales_Keywords`(Resume_Title,KeySkills) VALUE ('"+filename+"','"+resultCommaseperated+"')");


	            PreparedStatement stmt=connection.prepareStatement("INSERT INTO `Banking_Keywords`(JD,KeySkills) VALUE (?,?)");  
	            stmt.setString(1,jdcontent);//1 specifies the first parameter in the query  
	            stmt.setString(2,resultCommaseperated);  
	             
	              
	            int i=stmt.executeUpdate(); 
	            
				// iterate through the java resultset
				
				stmt.close();
			} catch (Exception e) {
				System.out.println(e);
			}finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
