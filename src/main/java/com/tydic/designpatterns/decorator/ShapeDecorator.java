package com.tydic.designpatterns.decorator;

/**
 * @Author fancq
 * @Date 2019/9/17 15:51
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public abstract class ShapeDecorator implements Shape {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
