package ru.xxlabaza.feignsample.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * <p>
 * @author Artem Labazin
 * <p>
 * @since Apr 18, 2015 | 6:27:32 PM
 * <p>
 * @version 1.0.0
 */
@FeignClient("feignsample")
interface ClientApi {

    @RequestMapping(
            value = "/who",
            method = RequestMethod.GET
    )
    String getWho ();
}
