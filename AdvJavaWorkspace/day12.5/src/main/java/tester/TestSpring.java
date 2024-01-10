package tester;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfiguration;
import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		/*
		 * Starting SC from java config class baesd  instructions + annotations
		 *  BeanFactory i/f <---- ApplicationContext : sub i/f (=SC) imple
		 * class : AnnotationConfigApplicationContext
		 */
		try (AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfiguration.class)) {
			System.out.println("SC up n running ....");
			// deposit 1000 in the ATM
			// app making the 1st demand to SC --to get READY TO use bean
			ATMImpl atm1 = ctx.getBean("my_atm", ATMImpl.class);
			atm1.deposit(1000);
			ATMImpl atm2 = ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(atm1 == atm2);// t
		} // ctx.close() --> SC shutting down --> singleton --> destroy --> GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}