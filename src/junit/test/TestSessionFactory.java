package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSessionFactory {

	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

	@Test
	public void testCreateTable() {
	}

}
