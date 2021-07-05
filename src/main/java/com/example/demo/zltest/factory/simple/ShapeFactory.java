package com.example.demo.zltest.factory.simple;

public class ShapeFactory {

	public Shape getShare(String share){
		if(share == null ){
             return null;
		}
		if(share.equalsIgnoreCase("square")){
			return new Square() ;
		}else if(share.equalsIgnoreCase("rectangle")){
			return new Rectangle();
		}
		return null;
	}

}
