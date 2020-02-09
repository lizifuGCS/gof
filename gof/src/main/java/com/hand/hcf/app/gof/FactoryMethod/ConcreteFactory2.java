package com.hand.hcf.app.gof.FactoryMethod;

/**
 * @Description
 * @Author zifu.li
 * @Date 2020/2/9 16:20
 * @Version 1.0
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}
