package com.cheshi.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ceshi.bean.UserAddress;
import com.ceshi.service.OrderService;
import com.ceshi.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author lfy
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Reference
	UserService userService;
	
	//当initOrder方法出错时则调用errMethod
	@HystrixCommand(fallbackMethod="errMethod")
	public List<UserAddress> initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("userid"+userId);
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}
	
	public List<UserAddress> errMethod(String userId) {
		
		return Arrays.asList(new UserAddress());
	}
	
	

}
