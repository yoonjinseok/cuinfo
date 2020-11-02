package com.cyberup.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cyberup.service.common.DeadLinkCheckService;

public class DeadLinkCheckController {

	@Autowired
	private DeadLinkCheckService deadLinkCheckService;
	
	
	public void execute(){
		
		deadLinkCheckService.deadLinkCheck(0);
		deadLinkCheckService.AcademyDeadLinkCheck(0);
	}
	
}
