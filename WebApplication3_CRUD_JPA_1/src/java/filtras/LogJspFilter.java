/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtras;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Jurate Valatkevicien
 */
@WebFilter (filterName = "LogJspFilter", urlPatterns = "*.jsp")
public class LogJspFilter implements Filter{
    private static final Log log = LogFactory.getLog(LogJspFilter.class);
            
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        log.info("prašo JSP");
        fc.doFilter(request, response); //ctrl+r
        log.info("Davėm JSP");     
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }
}
