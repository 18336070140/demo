package com.example.demo.zltest.factory.factoryMethed;

public abstract class RectangleFectory implements ShapeFactory {

	public Rectangle getShare(){
		return new Rectangle();
	}
}
