package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.Product;

public class ProductDAO {
          public void addProduct(Product p) throws ClassNotFoundException, SQLException {
        	  ConnectionManager cm = new ConnectionManager();
        	  Connection con =cm.establishConnection();
        	  String que="insert into product(productId ,productName ,minSellQuantity ,price ,quantity ) values(?,?,?,?,?)";
        	  PreparedStatement ps = con.prepareStatement(que);//run time insert query
        	  ps.setInt(1,p.getProductId());
        	  ps.setString(2,p.getProductName());
        	  ps.setInt(3,p.getMinSellQuantity());
        	  ps.setInt(4,p.getPrice());
        	  ps.setInt(5,p.getQuantity());
        	  ps.executeUpdate();
        	  cm.closeConnection();
          }
          public void display() throws ClassNotFoundException, SQLException
          {
        	//1.jdbc connection
      		ConnectionManager cm=new ConnectionManager();
      		Connection con=cm.establishConnection();
      		//2.create the statement create class create statement execute query
              Statement st=con.createStatement();	
              //3.write and execute the query
              ResultSet rt =st.executeQuery("select * from product");
              //4. print
              while(rt.next())
              {
            	 System.out.println(rt.getInt("productId")+" | "+rt.getString("productName")+" | "+rt.getInt("minSellQuantity")+" | "+rt.getInt("price")+" | "+rt.getInt("quantity")+" | ");
            	 
              }
              cm.closeConnection();
          }
          public void updateProduct(Product p) throws ClassNotFoundException, SQLException 
          {
        	  ConnectionManager cm = new ConnectionManager();
        	  Connection con =cm.establishConnection();
        	  String que="update product set productName=?,minSellQuantity=? ,price=? ,quantity=? where productId=?";
        	  PreparedStatement ps = con.prepareStatement(que);//run time insert query
        	  ps.setString(1,p.getProductName());
        	  ps.setInt(2,p.getMinSellQuantity());
        	  ps.setInt(3,p.getPrice());
        	  ps.setInt(4,p.getQuantity());
        	  ps.setInt(5,p.getProductId());
        	  ps.executeUpdate();
        	  cm.closeConnection();
          }
          public void deleteProduct(Product p) throws ClassNotFoundException, SQLException
          {
        	  ConnectionManager cm = new ConnectionManager();
        	  Connection con =cm.establishConnection();
        	  String que="delete from product where productId=?";
        	  PreparedStatement ps = con.prepareStatement(que);//run time insert query
        	  ps.setInt(1,p.getProductId());
        	  ps.executeUpdate();
        	  cm.closeConnection();
        	  
          }
}
