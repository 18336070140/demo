package com.example.demo.zltest.singlton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TTT1   {

//public static void main(String[]args) {
//		HungrySinglten hung = HungrySinglten.getsinglten();
//	try {
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sing_file"));
//		oos.writeObject(hung);
//
//		File file = new File("sing_file");
//
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//		HungrySinglten hungFil = (HungrySinglten)ois.readObject();
//
//		System.out.println(hung ==hungFil );
//
//	} catch (IOException e) {
//		e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//}

	public static void main(String[] args) {
		HungrySinglten hung = HungrySinglten.getsinglten();
		Class objectHun =HungrySinglten.class;
		try {
			Constructor cons = objectHun.getDeclaredConstructor();
			cons.setAccessible(true);
			HungrySinglten hung1 = (HungrySinglten)cons.newInstance();

			Field fiag = objectHun.getDeclaredField("");
			fiag.setAccessible(true);

			fiag.set(hung,"ss");

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

}
