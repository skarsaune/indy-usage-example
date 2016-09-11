package no.kantega.jvm.indy.example;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class SomeProvider {
	
	public static CallSite boostrap(MethodHandles.Lookup caller,
            String invokedName,
            MethodType invokedType) throws Exception {
		System.out.println("Bootstrap method called");
		MethodType methodType = invokedType; //MethodType.methodType(Void.class, new Class<?>[0])
	    MethodHandles.Lookup lookup = MethodHandles.lookup();
	    MethodHandle methodHandle = lookup.findStatic(SomeProvider.class, "delegate", methodType);
	    return new ConstantCallSite(methodHandle);
	}
	
	public static void delegate() {
		System.out.println("Actual method called");
	}
}
