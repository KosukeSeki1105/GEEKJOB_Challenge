package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.UserData;
import java.text.SimpleDateFormat;
import jums.JumsHelper;

public final class mydata_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession hs       = request.getSession();
    UserData userDetail  = (UserData)hs.getAttribute("userDetail");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");
    JumsHelper jh        = JumsHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>会員情報（閲覧画面）</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>会員情報詳細</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>ユーザ名</th>\n");
      out.write("                <th>パスワード</th>\n");
      out.write("                <th>メールアドレス</th>\n");
      out.write("                <th>住所</th>\n");
      out.write("                <th>総購入金額</th>\n");
      out.write("                <th>登録日時</th>                \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td align=center>");
      out.print( userDetail.getName());
      out.write("</td>\n");
      out.write("                <td align=center>");
      out.print( userDetail.getPassword());
      out.write("</td>\n");
      out.write("                <td align=center>");
      out.print( userDetail.getMail());
      out.write("</td>\n");
      out.write("                <td align=center>");
      out.print( userDetail.getAddress());
      out.write("</td>\n");
      out.write("                <td align=center>");
      out.print( userDetail.getTotal());
      out.write("円</td>\n");
      out.write("                <td align=center>");
      out.print( sdf.format(userDetail.getNewDate()));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <br>");
      out.print( jh.myhistory());
      out.write("<br>\n");
      out.write("        <br>");
      out.print( jh.myupdate());
      out.write("<br>\n");
      out.write("        <br>");
      out.print( jh.mydelete());
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
