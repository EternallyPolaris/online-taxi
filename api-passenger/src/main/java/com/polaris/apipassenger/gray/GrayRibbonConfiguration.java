package com.polaris.apipassenger.gray;

import com.netflix.loadbalancer.IRule;
import com.polaris.apipassenger.annotation.ExcudeRibbonConfig;
import org.springframework.context.annotation.Bean;

@ExcudeRibbonConfig
public class GrayRibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new GrayRule();
    }
}
