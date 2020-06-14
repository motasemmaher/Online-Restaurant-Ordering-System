package org.apache.jsp.view.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Error;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Login V2</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/login.css\"></link>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div class=\"limiter\">\n");
      out.write("\t\t<div class=\"container-login100\">\n");
      out.write("\t\t\t<div class=\"wrap-login100\">\n");
      out.write("\t\t\t\t<form class=\"login100-form validate-form\" action=\"../../User\"\n");
      out.write("\t\t\t\t\tmethod=\"POST\">\n");
      out.write("\t\t\t\t\t<span class=\"login100-form-title p-b-26\"> Welcome </span> <span\n");
      out.write("\t\t\t\t\t\tclass=\"login100-form-title p-b-48\"> <i\n");
      out.write("\t\t\t\t\t\tclass=\"zmdi zmdi-font\"></i>\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"Username\"> <span\n");
      out.write("\t\t\t\t\t\t\tclass=\"focus-input100\" data-placeholder=\"Username\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t");

							try{
								
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t<span>\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print( ((Error)session.getAttribute("error")).getMessage() );
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t");
}
							catch(Exception exp){}
						
      out.write("\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn\">\n");
      out.write("\t\t\t\t\t\t<div class=\"wrap-login100-form-btn\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"login100-form-bgbtn\"></div>\n");
      out.write("\t\t\t\t\t\t\t<button class=\"login100-form-btn\">Login</button>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t<h4>&copy;Mo'tasem Maher Salem 125965</h4>\n");
      out.write("\t\t\t\t<h4>&copy;Osama Khaled Alzoubi 129325</h4>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<br>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<div id=\"dropDownSelect1\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
