package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import jums.JumsHelper;
import jums.UserData;

public final class loginresultfalse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs              = request.getSession();
    UserData ud                 = (UserData)hs.getAttribute("loginState");
    String s                    = (String)request.getAttribute("falseLogin");
    ArrayList<String> nullLogin = (ArrayList<String>)hs.getAttribute("nullLogin");
    JumsHelper jh               = JumsHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ログイン失敗</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>ログイン失敗</h1>\n");
      out.write("        <!--ログイン成功の場合-->\n");
      out.write("        ");
 if(ud != null){ 
      out.write(" \n");
      out.write("        成功<br>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("        \n");
      out.write("        ");
 if(s == null){ 
      out.write(" \n");
      out.write("        失敗<br>\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("        \n");
      out.write("        <!--フォーム未入力の場合-->\n");
      out.write("        ");
if(nullLogin != null){ 
      out.write("\n");
      out.write("        ");
 for(String value:nullLogin){ 
      out.write("<b>");
      out.print( value);
      out.write("</b>が未入力です。<br><br>");
 }
      out.write("\n");
      out.write("        <br>");
      out.print( jh.loginBack());
      out.write("\n");
      out.write("        ");
 }
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
