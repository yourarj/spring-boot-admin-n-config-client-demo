package mr.awesome.demos.springboot.adminclient.myspringbootadminnconfigclient.rs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/env/")
public class MyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @Autowired
    ConfigurableEnvironment environment;

    @GetMapping("fetch-list")
    protected Map<String,String> getPropertyValue(@RequestParam("vars") String[] variables){
        LOGGER.info("GET request for properties `{}`", Arrays.toString(variables));
        Map<String, String> varMap = new HashMap<>(variables.length,1);
        for (String variable : variables) {
            varMap.put(variable, environment.getProperty(variable));
        }
        return varMap;
    }
}
