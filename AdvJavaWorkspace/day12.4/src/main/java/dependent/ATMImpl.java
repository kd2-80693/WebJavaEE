package dependent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;

//singleton n eager
//dep : soap layer
@Component("my_atm")
public class ATMImpl implements ATM {
	@Autowired(required = false) //autowire=byType
	@Qualifier("soapTransport")//byName
	private Transport myTransport;

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);

	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// depnt obj is using
		// the depcy to inform backend bank

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);// depnt is using
		// the depcy for informing the bank
	}
	@PostConstruct
	public void anyInit() {
		System.out.println("in init " + myTransport);// not null
	}
	@PreDestroy
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
