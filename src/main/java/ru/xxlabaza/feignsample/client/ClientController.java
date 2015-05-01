package ru.xxlabaza.feignsample.client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>
 * @author Artem Labazin
 * <p>
 * @since Apr 18, 2015 | 6:30:13 PM
 * <p>
 * @version 1.0.0
 */
@RestController
class ClientController {

    @Autowired
    private ClientService sampleService;

    @RequestMapping(
            value = "/who",
            method = RequestMethod.GET
    )
    public String getWho () {
        return sampleService.getWho();
    }

    @RequestMapping(
            value = "/service/clientsample/who",
            method = RequestMethod.GET
    )
    public String getAnotherServiceWho () {
        return sampleService.getAnotherServiceWho();
    }

    @RequestMapping(
            value = "/service/{name}",
            method = RequestMethod.GET
    )
    public String getServiceUrl (@PathVariable("name") String name) {
        return sampleService.getServiceUrl(name);
    }

    @RequestMapping(
            value = "/service",
            method = RequestMethod.GET
    )
    public List<String> getServices () {
        return sampleService.getServices();
    }

    @RequestMapping(
            value = "/hystrix/{request}",
            method = RequestMethod.GET
    )
    public String checkHystrix (@PathVariable("request") String request) {
        return sampleService.checkHystrix(request);
    }
}
