package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import jums.JumsHelper;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    //セッション("cart")の商品コード番号を取得
    HttpSession hs = request.getSession();
    String cart    = (String)hs.getAttribute("cart");
    
    //配列に商品コード番号を追加
    //セッションに配列を追加
    //表示のためにセッションから("cartTotal")を取得
    ArrayList<String> al = new ArrayList<String>();
    al.add(cart);
    hs.setAttribute("cartTotal", cart);
    ArrayList<String> cartTotal = (ArrayList<String>)hs.getAttribute("cartTotal");
    
    //セッション("cart")破棄
    hs.removeAttribute("cart");
    
    JumsHelper jh = JumsHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>カートページ</title>\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        <h1>カートの中身</h1>\n");
      out.write("        ");
 for(String value:cartTotal){ 
      out.write("\n");
      out.write("        ");
      out.print( value);
      out.write("<br>\n");
      out.write("        ");
 }
      out.write("        \n");
      out.write("        <br><br>");
      out.print( jh.top());
      out.write("\n");
      out.write("        \n");
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
