package com.xworkz.coreapp.internet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.coreapp")
public class CoreConfigure {
    CoreConfigure(){
        System.out.println("CoreConfigure invoked");
    }
}
