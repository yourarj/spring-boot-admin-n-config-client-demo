package mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.rs;

import mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.service.IEnvironmentVariableFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/env/")
public class SimpleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    IEnvironmentVariableFetcher environmentVariableFetcher;

    @GetMapping("fetch-list")
    protected Map<String,String> getPropertyValue(@RequestParam("vars") String[] variables){
        return environmentVariableFetcher.getEnvironmentVariables(variables);
    }
}
