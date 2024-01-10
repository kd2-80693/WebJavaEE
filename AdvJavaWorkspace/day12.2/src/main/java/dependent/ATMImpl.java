package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
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
		//the depcy for informing the bank
	}
	// setter based D.I 
	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter " + this.myTransport);// not null
	}

	// init method is invoked for singleton n prototype beans 
	//after D.I 
	//For singleton n eager : @ SC startup , 1 time
	//For singleton n lazy : @ 1st demand(ctx.getBean) , 1 time
	//For prototype (ALWAYS lazy !) : per every demand 	
	public void anyInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// destroy method -- @ end of life cycle --> Before G.C --> for 
	//singleton beans only !
	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
