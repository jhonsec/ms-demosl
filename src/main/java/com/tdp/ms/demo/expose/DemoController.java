package com.tdp.ms.demo.expose;

import com.tdp.ms.demo.business.DemoService;
import com.tdp.ms.demo.model.DemoRequest;
import com.tdp.ms.demo.model.DemoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Class: DemoController. <br/>
 * <b>Copyright</b>: &copy; 2019 Telef&oacute;nica del Per&uacute;<br/>
 * <b>Company</b>: Telef&oacute;nica del Per&uacute;<br/>
 *
 * @author Telef&oacute;nica del Per&uacute; (TDP) <br/>
 *         <u>Service Provider</u>: Everis Per&uacute; SAC (EVE) <br/>
 *         <u>Developed by</u>: <br/>
 *         <ul>
 *         <li>Developer name</li>
 *         </ul>
 *         <u>Changes</u>:<br/>
 *         <ul>
 *         <li>YYYY-MM-DD Creaci&oacute;n del proyecto.</li>
 *         </ul>
 * @version 1.0
 */
@RestController
@RequestMapping("/demo/v1/greeting")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public Mono<DemoResponse> indexGet() {
        return Mono.justOrEmpty(demoService.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DemoResponse> indexPost(@RequestBody DemoRequest request) {
        return Mono.justOrEmpty(demoService.put(request.getName()));
    }



}
