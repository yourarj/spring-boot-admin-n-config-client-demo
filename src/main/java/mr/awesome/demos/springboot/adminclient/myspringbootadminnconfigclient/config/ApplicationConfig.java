package mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.config;

import mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.service.IEnvironmentVariableFetcher;
import mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.service.impl.SimpleEnvironmentVariableFetcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@RefreshScope
public class ApplicationConfig {

    @Value("${application.environment.decorator.prefix:}")
    private String decoratorString;

    @Bean
    @RefreshScope
    protected IEnvironmentVariableFetcher environmentVariableFetcher(ConfigurableEnvironment environment){
        return new SimpleEnvironmentVariableFetcher(environment, decoratorString);
    }
}
