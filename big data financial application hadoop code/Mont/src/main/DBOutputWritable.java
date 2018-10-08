package main;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class DBOutputWritable implements Writable, DBWritable
{
   private String c_name;
   private String s_name;
   private int day;
   private double p5;
   private double p25;
   private double p75;
   private double p95;

   public DBOutputWritable(String c_name, String s_name, int day, double p5, double p25, double p75, double p95)
   {
     this.c_name = c_name;
     this.s_name = s_name;  
     this.day = day;
     this.p5 = p5;
     this.p25 = p25;
     this.p75 = p75;
     this.p95 = p95;
   
   
   }

   public void readFields(DataInput in) throws IOException {   }

   public void readFields(ResultSet rs) throws SQLException
   {
     /*name = rs.getString(1);
     count = rs.getInt(2);*/
	   c_name = rs.getString(2);
	   s_name = rs.getString(3);
	   day = rs.getInt(4);
	   p5 = rs.getDouble(5);
	   p25 = rs.getDouble(6);
	   p75 = rs.getDouble(7);
	   p95 = rs.getDouble(8);
   }

   public void write(DataOutput out) throws IOException {    }

   public void write(PreparedStatement ps) throws SQLException
  
   {
	   
	   //ps.execute("TRUNCATE TABLE prediction_data");
       
	   //ps.setInt(1,1);
	   ps.setString(1,c_name);
	   ps.setString(2,s_name);
	   ps.setInt(3,day);
	   ps.setDouble(4,p5);
	   ps.setDouble(5,p25);
	   ps.setDouble(6,p75);
	   ps.setDouble(7,p95);
	  // System.out.println(ps.execute());
   }
}