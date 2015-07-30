package com.mykhaylenko.autoit;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mykhaylenko.ejb.session.service.BookSessionBeanRemote;
import com.mykhaylenko.ejb.session.service.LibrarySessionBeanRemote;




public class EJBClient {
    
    InitialContext ctx;
//    Properties env;
    {
        try {
//            env = new Properties();
//            env.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
//            env.put("java.naming.provider.url", "t3://weblogicServer:7001");
//            ctx = new InitialContext(env);
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void testEjb() throws JMSException {
        try {
//            NamingEnumeration<Binding> listBindings = ctx.listBindings("");
//            while(listBindings.hasMore()){
//                Binding next = listBindings.next();
//                System.out.println(next.getClassName());
//            }
            LibrarySessionBeanRemote library = (LibrarySessionBeanRemote) ctx.lookup("LibrarySessionBean#com.mykhaylenko.ejb.session.service.LibrarySessionBeanRemote");
//            library.addBook("First book");
//            library.addBook("Second book");
            
            BookSessionBeanRemote bookStore = (BookSessionBeanRemote) ctx.lookup("BookSessionBean#com.mykhaylenko.ejb.session.service.BookSessionBeanRemote");
            bookStore.addBook("bookForStore");
            
//            
            Queue bookQueue = (Queue) ctx.lookup("com/mykhaylenko/training/BookQueue");
            QueueConnectionFactory connectionFactory = (QueueConnectionFactory) ctx.lookup("com/mykhaylenko/training/ConnectionFactory");
            QueueConnection connection = connectionFactory.createQueueConnection();
            connection.start();
            QueueSession session = (QueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueSender sender = session.createSender(bookQueue);
            
            TextMessage textMessage = session.createTextMessage("MDB Book");
            sender.send(textMessage);
            connection.close();
            
            printBookList(library.getBooks());
            System.out.println("Library size: " + library.getLibrarySize());
            System.out.println("Library size + BookStore size: " + bookStore.getBooksCount());
            printBookList(bookStore.getAllBooks());
            //TODO: configure and test EJB security
//            System.out.println(library.getAdminString());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private void printBookList(List<String> books) {
        for (String book : books) {
            System.out.println(book);
        }
    }
    
    public static void main(String[] args) throws JMSException{
        System.out.println("Start");
        EJBClient ejbClient = new EJBClient();
        ejbClient.testEjb();
    }
}
