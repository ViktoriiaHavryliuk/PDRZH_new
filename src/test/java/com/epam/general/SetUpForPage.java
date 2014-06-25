package com.epam.general;

	import java.sql.*;
	import java.util.NoSuchElementException;
	import java.util.concurrent.TimeUnit;

	import org.jbehave.core.annotations.AfterScenario;
	import org.jbehave.core.annotations.BeforeScenario;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class SetUpForPage {

		protected static WebDriver driver;
		private static final String DB_DRIVER = "org.postgresql.Driver";
		private static final String DB_CONNECTION = "jdbc:postgresql://evbyminsd7238.minsk.epam.com:5432/pdrzh_for_testers";
		private static final String DB_USER = "postgres";
		private static final String DB_PASSWORD = "123";


		//SQL delete statement
		protected static void deleteRecordFromDbUserTable(String login) throws SQLException {
			Connection dbConnection = null;
			Statement statementOne = null;
			Statement statementTwo = null;
			Statement statementThree = null;

			//3 delete statements
			String deleteIDFromPerson = "DELETE FROM person WHERE ID_CLIENT IN (SELECT id_client FROM client WHERE login = '"+login+"')";
			String deleteIDFromRoles = "DELETE FROM roles WHERE id_client in (select id_client from client where login = '"+login+"')";
			String deleteLoginFromClient = "DELETE FROM client WHERE id_client in (select id_client from client where login = '"+login+"')";

			try {
				dbConnection = getDBConnection();
				statementOne = dbConnection.createStatement();
				System.out.println(deleteIDFromPerson);
				statementTwo = dbConnection.createStatement();
				System.out.println(deleteIDFromRoles);
				statementThree = dbConnection.createStatement();
				System.out.println(deleteLoginFromClient);

				// execute delete SQL stetement
				statementOne.executeUpdate(deleteIDFromRoles);
				System.out.println("Records is deleted from Roles table!");
				statementTwo.executeUpdate(deleteIDFromPerson);
				System.out.println("Records is deleted from Person table!");
				statementThree.executeUpdate(deleteLoginFromClient);
				System.out.println("Records is deleted from Client table!");

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			} finally {

				if (statementOne != null) {
					statementOne.close();
				}
				if (statementTwo != null) {
					statementTwo.close();
				}
				if (statementThree != null) {
					statementThree.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}

			}

		}
		
		//method that connect to DB
		private static Connection getDBConnection() {
			Connection dbConnection = null;
			try {
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			try {
				dbConnection = DriverManager.getConnection(
						DB_CONNECTION, DB_USER,DB_PASSWORD);
				return dbConnection;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return dbConnection;
		}
		
		//method that checks the presence of element
		public static boolean isElementPresent(By element)
		{
			boolean value = false;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try{
				if (driver.findElement(element).isEnabled());

				{
					value = true;
				}
			} catch (NoSuchElementException e) {
				System.out.println("Unable to locate element: " + element);
			} 
			return value;
		}

		@BeforeScenario
		public void startDriver() throws Exception {

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@AfterScenario
		public void stopDriver() throws Exception {
			driver.close();

		}

		public WebDriver getDriver() {
			return driver;
		}

		public void open(String url) {
			driver.get(url);
		}

	}

