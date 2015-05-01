package ru.xxlabaza.feignsample.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

/**
 *
 * <p>
 * @author Artem Labazin
 * <p>
 * @since Apr 18, 2015 | 6:28:29 PM
 * <p>
 * @version 1.0.0
 */
@Service
class ClientService {

    @Autowired
    private ClientApi clientSampleApi;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${eureka.instance.metadataMap.instanceId}")
    private String eurekaInstanceId;

    public String getWho () {
        return eurekaInstanceId;
    }

    public String getAnotherServiceWho () {
        return clientSampleApi.getWho();
    }

    public String getServiceUrl (String serviceName) {
        List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
        if (list != null && list.size() > 0) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

    public List<String> getServices () {
        return discoveryClient.getServices();
    }

    @HystrixCommand(fallbackMethod = "fallbackCheckHystrix")
    public String checkHystrix (String request) {
        if ("ok".equalsIgnoreCase(request)) {
            return "GOOD EXECUTION HYSTRIX METHOD";
        } else {
            throw new RuntimeException();
        }
    }

    public String fallbackCheckHystrix (String request) {
        return "BAD EXECUTION HYSTRIX METHOD with request: " + request;
    }
}
