package com.hand.hcf.app.gof.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description
 * @Author zifu.li@hand-china.com
 * @Date 2020/2/9 16:35
 * @Version 1.0
 */
@ConfigurationProperties("base")
@Data
public class BaseProperties {
    private final Product product = new Product();
    public Product getProduct(){
        return this.product;
    }

    public static class Product{

        private String mode;
        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }
    }
}
