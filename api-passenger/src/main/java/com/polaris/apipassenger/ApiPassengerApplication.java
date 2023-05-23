package com.polaris.apipassenger;

import com.polaris.apipassenger.annotation.ExcudeRibbonConfig;
import com.polaris.apipassenger.gray.GrayRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(
		excludeFilters = {
				@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcudeRibbonConfig.class)
		})
//@RibbonClient(name = "service-sms", configuration = GrayRibbonConfiguration.class)
public class ApiPassengerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiPassengerApplication.class, args);
	}

	@GetMapping("/test")
	public String test(){
		System.out.println("api-passenger-test");
		return "api-passenger";
	}
}
