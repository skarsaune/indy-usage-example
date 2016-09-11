package no.kantega.jvm.indy.example;

import no.kantega.jvm.dynamic.annotation.IndyMethod;

public class SomeService {
	
	@IndyMethod(implementation="no.kantega.jvm.indy.example.SomeProvider", method= "boostrap")
	public static void doStuff() {
		throw new UnsupportedOperationException("doStuff() should be delegated by <invokedynamic> to SomeProvider.dummyMethod");
	}
}
