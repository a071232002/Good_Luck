package com.cha104g2.goodluck;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.*;

public class Test {
	
	public static void main (String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		SessionFactory factory = new MetadataSources(registry)
				.buildMetadata()
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptno(110);
		dept.setDname("人事部");
		dept.setLoc("中壢");
		
		session.save(dept);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
