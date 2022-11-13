package servlet;
import ejb.RoomBeanLocal;
import java.io.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "roomclient", urlPatterns = {"/roomclient"})
public class RoomClient extends HttpServlet {
@EJB RoomBeanLocal obj;
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
try {
int no=Integer.parseInt(request.getParameter("t1"));
String b=request.getParameter("btn");
int res=0;
if(b.equals("CheckIN"))
{
res=obj.checkin(no);
if (res==1)
out.println(no + " rooms check-in");
}
if(b.equals("CheckOUT"))
{
res=obj.checkout(no);
if (res==1)
out.println(no + " rooms check-out");
}
if(res==0)
out.println("Not possible to do Check IN / OUT");
out.println("<br><br><a href=index.html> Back </a>");
}
finally {
out.close();
}
}
}