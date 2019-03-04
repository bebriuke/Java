/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author trolis
 */
public class LoggerFilter implements Filter {
    
    private static final Log log = LogFactory.getLog(LoggerFilter.class);

    
    public LoggerFilter() {
        
    }    
    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest) request;
        log.info("uzklausa is: "+r.getRemoteAddr());
        chain.doFilter(request, response);
        log.info("uzklausa pabaigem");
       
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("inicializuojam filtra");
    }

    @Override
    public void destroy() {
        log.info("naikinam filtra");
    }

    
    
}
