package mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.service.impl;

import lombok.RequiredArgsConstructor;
import mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.service.IEnvironmentVariableFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class SimpleEnvironmentVariableFetcher implements IEnvironmentVariableFetcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEnvironmentVariableFetcher.class);

    private final ConfigurableEnvironment environment;
    private final String prefix;

    @Override
    public Map<String, String> getEnvironmentVariables(String[] variables) {
        LOGGER.info("GET request for properties `{}`", Arrays.toString(variables));
        Map<String, String> varMap = new HashMap<>(variables.length, 1);
        for (String variable : variables) {
            varMap.put(variable, getAndDecorateEnvironmentValue(variable));
        }
        return varMap;
    }

    private String getAndDecorateEnvironmentValue(String variable) {
        return String.format("%s:%s", prefix, environment.getProperty(variable));
    }
}
