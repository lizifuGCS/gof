package com.hand.hcf.app.gof.FactoryMethod;

/**
 * @Description  //具体产品1：实现抽象产品中的抽象方法
 * @Author zifu.li
 * @Date 2020/2/9 16:16
 * @Version 1.0
 */
public class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品1显示...");
    }
}
