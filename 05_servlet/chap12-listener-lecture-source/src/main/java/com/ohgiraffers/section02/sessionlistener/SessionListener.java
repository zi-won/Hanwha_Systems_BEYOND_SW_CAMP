package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebServlet
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session attribute added!");
        System.out.println("session 추가 된 attr:" + event.getName() + ", value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session attribute removed!");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session attribute replaced!");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session attribute created!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session attribute destroyed!");
    }
}
