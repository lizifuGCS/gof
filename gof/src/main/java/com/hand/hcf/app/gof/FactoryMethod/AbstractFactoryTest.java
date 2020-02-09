package com.hand.hcf.app.gof.FactoryMethod;


import com.hand.hcf.app.gof.config.BaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author zifu.li@hand-china.com
 * @Date 2020/2/9 16:23
 * @Version 1.0
 */
@Controller
public class AbstractFactoryTest {

    @Autowired
    private BaseProperties baseProperties;

    @RequestMapping("/test")
    @ResponseBody
    public  String test() {
        AbstractFactory af;
        if (baseProperties.getProduct().getMode().equals("product1")){
            af= new ConcreteFactory1();
            af.newProduct();
            return "产品1";
        }else if (baseProperties.getProduct().getMode().equals("product2")){
            af= new ConcreteFactory2();
            af.newProduct();
            return "产品2";
        }else {
            return "目前没有对应的产品";
        }
    }
}
