package com.design.adapter;

public class Adapter  implements Tagert {

	private Adaptee adaptee = new Adaptee();
	@Override
	public void reu() {
		adaptee.adapterReques();
	}
}
