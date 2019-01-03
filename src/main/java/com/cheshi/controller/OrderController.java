package com.cheshi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceshi.bean.UserAddress;
import com.ceshi.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping("/init")
	public List<UserAddress> initOrder(@RequestParam("uid")String userId){
		return orderService.initOrder(userId);
	}
}
