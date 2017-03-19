package cn.wmn.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import cn.wmn.Students;

public class StudentsTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	
	
        @Before
        public void init(){
        	//获得配置对象
        	Configuration configuration = new Configuration().configure();
        	//获得服务注册对象
        	ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	//获得SessionFactory工厂
            sessionFactory = configuration.buildSessionFactory();
            //创建Session对象
            session = sessionFactory.openSession();
            //开启事务
            transaction = session.beginTransaction();
        
        }
        @After
        public void destory(){
        	try {
				transaction.commit();
				session.close();
				sessionFactory.close();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
        }
        @Test
        
        public void testSaveStudents(){
        	Students s = new Students(1, "张三", "男", new Date(), "临安");
        	session.save(s);
        	
        }
        
    	@Test
    	public void  testWriteBlod() throws IOException{
    		Students s = new Students(1, "张三", "男", new Date(), "临安");
    		File f = new File("e:"+File.separator+"01.jpg");
    		InputStream in = new FileInputStream(f);
    		Blob image = Hibernate.getLobCreator(session).createBlob(in, in.available());
    		s.setPicture(image);
    		session.save(s);
    		
    	}
        @Test
        public void testReadBlob() throws Exception{
        	Students s =session.get(Students.class, 1);
        	//获得Blob对象
        	Blob image = s.getPicture();
        	//获得照片的输入流
        	InputStream in = image.getBinaryStream();
            //创建输出流
        	File f = new File("e:"+File.separator+"02.jpg");
        	//获得输出流
            OutputStream out = new FileOutputStream(f);
            //创建缓冲区
            byte[] buff = new byte[in.available()];
            in.read();
            out.write(buff);
            in.close();
            out.close();
        }
        
}
