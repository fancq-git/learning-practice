package com.tydic.designpatterns.decorator;

/**
 * @Author fancq
 * @Date 2019/9/17 15:53
 * @Version 1.0
 * @Email 1191071905@qq.com
 **/
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("这是红色的圆圈");
    }

    public static void main(String[] args) {
        Shape shape = new Circle();
        ShapeDecorator shapeDecorator = new RedShapeDecorator(shape);
        shapeDecorator.draw();
    }
}
