package cn.wmn;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.mysql.jdbc.Blob;

public class SessionTest {
 
	@Test
	public void testOpenSession(){
		Configuration configuration = new Configuration().configure();//获得配置对象
		 ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		 SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		 Session session = factory.getCurrentSession();
		 
	}
	
	@Test
	public void tesrGetCurrentSession(){
		
	}
	

	
	
}
