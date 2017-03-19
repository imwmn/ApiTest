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
        	//������ö���
        	Configuration configuration = new Configuration().configure();
        	//��÷���ע�����
        	ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	//���SessionFactory����
            sessionFactory = configuration.buildSessionFactory();
            //����Session����
            session = sessionFactory.openSession();
            //��������
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
        	Students s = new Students(1, "����", "��", new Date(), "�ٰ�");
        	session.save(s);
        	
        }
        
    	@Test
    	public void  testWriteBlod() throws IOException{
    		Students s = new Students(1, "����", "��", new Date(), "�ٰ�");
    		File f = new File("e:"+File.separator+"01.jpg");
    		InputStream in = new FileInputStream(f);
    		Blob image = Hibernate.getLobCreator(session).createBlob(in, in.available());
    		s.setPicture(image);
    		session.save(s);
    		
    	}
        @Test
        public void testReadBlob() throws Exception{
        	Students s =session.get(Students.class, 1);
        	//���Blob����
        	Blob image = s.getPicture();
        	//�����Ƭ��������
        	InputStream in = image.getBinaryStream();
            //���������
        	File f = new File("e:"+File.separator+"02.jpg");
        	//��������
            OutputStream out = new FileOutputStream(f);
            //����������
            byte[] buff = new byte[in.available()];
            in.read();
            out.write(buff);
            in.close();
            out.close();
        }
        
}
