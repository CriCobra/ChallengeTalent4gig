package com.challenge;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Processes
 */
@WebServlet("/Processes")
public class Processes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Processes() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String url = "jdbc:mysql://localhost:3306/Management";
	      String databaseUserName = "root";
	      String databasePassword = "root";
	      Statement stmt = null; 
	      ResultSet rs = null; 
	      Connection conn = null; 
	      PrintWriter out = response.getWriter();
	      out.print("<html><meta http-equiv=\"refresh\" content=\"10\"><body><h1 align='center'>Processes</h1><ul>"); 
	      LocalDate data = LocalDate.now();
	      LocalTime time = LocalTime.now(); 
	      out.print("<p> " + data + " " + time + "</p>");
	      try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
	            String SQL = "SELECT Process.ID, Process.ProcessName, Process.Description, Process.Periodicity Execution.ID, Execution.InfoExecution, Execution.FinalState, Execution.BeginAt FROM Process INNER JOIN Execution ON Process.ID=Execution.ID;";
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery(SQL); 
	            while (rs.next()) {
	            	out.print("<li>Processo: " + rs.getString("ProcessName") + ", Info Esecuzione: " + rs.getString("InfoExecution") + ", Stato finale: " + rs.getString("FinalState") + ", Periodicità: " + rs.getString("Periodicity") + ", Iniziato alle ore: " + rs.getString("BeginAt") +"</li>"); 
	            } 
	      } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
		
        
        	out.print("</ul></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
