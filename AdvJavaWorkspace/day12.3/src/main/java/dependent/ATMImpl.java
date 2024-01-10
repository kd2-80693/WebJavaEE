package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;

	//autowire , constr based D.I
	public ATMImpl(Transport t) {
		this.myTransport=t;
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

		public void anyInit() {
		System.out.println("in init " + myTransport);// not null
	}

	public void anyDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}

}
