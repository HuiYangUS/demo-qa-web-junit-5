package database;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pojos.database.tables.Employees;

public class DemoReadTableTest {

    SessionFactory sessionFactory;
    StandardServiceRegistry registry;

    @Test
    void runTest() {
	Session session = sessionFactory.openSession();
	session.beginTransaction();

	// table name is the pojo name, not the one from the database
	List<Employees> result = session.createQuery("FROM Employees", Employees.class).list();

	for (Employees employees : result) {
	    System.out.println(String.format("%d: %s %s, %s", employees.getEmployeeNumber(), employees.getFirstName(),
		    employees.getLastName(), employees.getJobTitle()));
	}

	session.getTransaction().commit();
	session.close();
    }

    @BeforeEach
    void setUp() {
	// configures settings from hibernate.config.xml (formerly hibernate.cfg.xml)
	registry = new StandardServiceRegistryBuilder()
		.configure(new File("src/test/resources/configs/hibernate.config.xml")).build();
	try {
	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	} catch (Exception e) {
	    System.out.println("Failed to load settings from hibernate.cfg.xml.");
	    if (registry != null) {
		StandardServiceRegistryBuilder.destroy(registry);
	    }
	    e.printStackTrace();
	}
    }

    @AfterEach
    void tearDown() {
	if (registry != null) {
	    StandardServiceRegistryBuilder.destroy(registry);
	}
    }

}
