package io.litmusblox.jd.dbreader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KeywordRepositoryDBImpl implements KeywordRepositoryDB {

	Connection connection = null;

	public List<String> getjds() {
		List<String> resultJd = new ArrayList<String>();

		try {
			// LOAD THE DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://jmdb-predictor-dev.cptvjl3vuwqy.ap-south-1.rds.amazonaws.com/role_predictor_dev",
					"jmlabsuser", "Testpass10");

			String queryjd = " select JDs from `YesBank_JDs`";

			// create the java statement
			Statement st = connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rsJd = st.executeQuery(queryjd);

			// iterate through the java resultset
			while (rsJd.next()) {

				String jds = rsJd.getString("JDs");
				resultJd.add(jds);

				// print the results
				// System.out.format("%s\n", keyskill);
			}

			st.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return resultJd;
	}

	public List<String> getKeywords() {
		List<String> result = new ArrayList<String>();

		try {
			// LOAD THE DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://jmdb-predictor-dev.cptvjl3vuwqy.ap-south-1.rds.amazonaws.com/role_predictor_dev",
					"jmlabsuser", "Testpass10");
			// here sonoo is database litmusbox_wordcount, root is username and
			// password is not set
			String query = " select Keywords from `YesBank_Keywords`";

			// create the java statement
			Statement st = connection.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {

				String keyskill = rs.getString("Keywords");
				result.add(keyskill);
			}

			st.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	
	}

}
