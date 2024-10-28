package com.imau.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserListener implements HttpSessionListener, 
									HttpSessionAttributeListener, 
									ServletContextListener {
    private int online_user_count = 0;
    private int logged_in_user_count = 0 ;
	
	/**
     * Default constructor. 
     */

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         online_user_count++;
         ServletContext application = arg0.getSession().getServletContext();
         application.setAttribute("online_user_count", online_user_count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        online_user_count--;
        ServletContext application = arg0.getSession().getServletContext();
        application.setAttribute("online_user_count", online_user_count);    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	if(arg0.getName().equals("loginStatus") && 
		   arg0.getValue().equals("OK")) {
    		logged_in_user_count++;
    		ServletContext application = arg0.getSession().getServletContext();
            application.setAttribute("logged_in_user_count", logged_in_user_count);
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    	if(arg0.getName().equals("loginStatus")){
    		logged_in_user_count--;
    		ServletContext application = arg0.getSession().getServletContext();
            application.setAttribute("logged_in_user_count", logged_in_user_count);
    	}    
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext application = arg0.getServletContext();
    	application.setAttribute("online_user_count", online_user_count);
    	application.setAttribute("logged_in_user_count", logged_in_user_count);
    }
	
}
