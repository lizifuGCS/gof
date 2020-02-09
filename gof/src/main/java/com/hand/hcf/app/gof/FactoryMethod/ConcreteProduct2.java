package com.hand.hcf.app.gof.FactoryMethod;

/**
 * @Description  //具体产品2：实现抽象产品中的抽象方法
 * @Author zifu.li
 * @Date 2020/2/9 16:17
 * @Version 1.0
 */
public class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品2显示...");
    }
}
