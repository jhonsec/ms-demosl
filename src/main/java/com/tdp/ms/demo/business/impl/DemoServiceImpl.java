package com.tdp.ms.demo.business.impl;

import com.tdp.ms.demo.business.DemoService;
import com.tdp.ms.demo.model.DemoResponse;
import org.springframework.stereotype.Service;

/**
 * Class: DemoServiceImpl. <br/>
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
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public DemoResponse get() {
        return new DemoResponse("Hello world!");
    }

    @Override
    public DemoResponse put(String name) {
        return new DemoResponse(name + " created!");
    }

}
