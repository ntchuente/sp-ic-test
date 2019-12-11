/**
 * 
 */
package com.sprintpay.ic.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SPRINT-PAY-NTW
 *
 */
@RestController
public class VersionController {
	@RequestMapping(method = { RequestMethod.GET }, value = { "/version" })
	public String getVersion() {
		return "1.0";
	}
}
