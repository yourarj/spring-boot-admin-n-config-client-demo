package mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.service;

import java.util.Map;

public interface IEnvironmentVariableFetcher {
    Map<String,String> getEnvironmentVariables(String[] variables);
}
