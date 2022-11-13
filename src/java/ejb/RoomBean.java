
package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;

@Stateless
public class RoomBean implements RoomBeanLocal {

    public int checkin(int no) {
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","root","123");
String sql1 = "select * from room";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql1);
rs.next();
int total=rs.getInt(1);
int occ=rs.getInt(2);
int free=total-occ;
System.out.println(total);
System.out.println(free);
if (free>=no)
{
String sql2="update room set occ=?"; 
PreparedStatement ps=con.prepareStatement(sql2);
ps.setInt(1, occ+no);
int res=ps.executeUpdate();
return res;
}
else return 0;
}
catch(Exception e)
{
return 0;
} }
public int checkout(int no) {
try
{ Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection("jdbc:mysql://localhost/roomdb","root","123");
String sql1 = "select * from room";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql1);
rs.next();
int total=rs.getInt(1);
int occ=rs.getInt(2);
if (occ>=no)
{
String sql2="update room set occ=?";
PreparedStatement ps=con.prepareStatement(sql2);
ps.setInt(1, occ-no);
int res=ps.executeUpdate();
return res;
}
else return 0;
}
catch(Exception e)
{
return 0;
}
}
}
