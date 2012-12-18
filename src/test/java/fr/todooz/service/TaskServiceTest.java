package fr.todooz.service;

import java.util.Date;

import javax.inject.Inject;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.todooz.domain.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TaskServiceTest {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Inject
	private TaskService taskService;

	  /* @Before
	   public void createSessionFactory() {
	      Configuration configuration = new Configuration();

	      configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
	      configuration.setProperty("hibernate.connection.url", "jdbc:derby:target/testdb;create=true");
	      configuration.setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver");
	      configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

	      configuration.addAnnotatedClass(Task.class);

	      sessionFactory = configuration.buildSessionFactory();
	   }*/

	   @After
	   public void cleanDb() {
	      Session session = sessionFactory.openSession();

	      Transaction transaction = session.beginTransaction();

	      session.createQuery("delete from Task").executeUpdate();

	      transaction.commit();

	      session.close();

	      //sessionFactory.close();
	   }

	   @Test
	   public void save() {
		   

		  //TaskService taskService = new TaskService();
		  //taskService.setSessionFactory(sessionFactory);

		  taskService.save(task());
	

	   }

	   private Task task() {
	      Task task = new Task();
	      task.setDate(new Date());
	      task.setTitle("Read Effective Java");
	      task.setText("Read Effective Java before it's too late");
	      task.setTags("java,java");
	      return task;
	   }
	   
	   @Test
	   public void delete() {
	       //TaskService taskService = new TaskService();
	       //taskService.setSessionFactory(sessionFactory);

	       Task task = task();

	       taskService.save(task);

	       taskService.delete(task.getId());

	       Session session = sessionFactory.openSession();

	       Assert.assertEquals(0, session.createQuery("from Task").list().size());

	       session.close();
	   }
	   
	   @Test
	   public void findAll() {
	       //TaskService taskService = new TaskService();
	       //taskService.setSessionFactory(sessionFactory);

	       taskService.save(task());
	       taskService.save(task());

	       Assert.assertEquals(2, taskService.findAll().size());
	   }

	   @Test
	   public void findByQuery() {
	       //TaskService taskService = new TaskService();
	       //taskService.setSessionFactory(sessionFactory);

	       taskService.save(task());
	       taskService.save(task());

	       Assert.assertEquals(2, taskService.findByQuery("read").size());
	       Assert.assertEquals(2, taskService.findByQuery("java").size());
	       Assert.assertEquals(0, taskService.findByQuery("driven").size());
	   }
	   
	   @Test
	   public void count() {
	      taskService.save(task());
	       taskService.save(task());

	       Assert.assertEquals(2, taskService.count());
	   }
	   
	   @Test
	   public void udpate() {
	       Task task = task();

	       taskService.save(task);
	       taskService.save(task);

	       Assert.assertEquals(1, taskService.count());
	   }

}
