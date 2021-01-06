package com.zxw.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ItheimaApplication {

	public static void main(String[] args) {

		SpringApplication.run(ItheimaApplication.class, args);
		System.out.println("itheima hello");
	}

}
