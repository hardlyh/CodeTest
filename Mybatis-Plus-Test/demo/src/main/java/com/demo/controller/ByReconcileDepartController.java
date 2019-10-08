package com.demo.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.ByReconcileDepart;
import com.demo.service.IByReconcileDepartService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lyh
 * @since 2019-10-08
 */
@RestController
public class ByReconcileDepartController {
	
	@Autowired
	private IByReconcileDepartService service;
	
	@GetMapping("/getIndex")
	public Object getIndex() {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(5);
		c.add(9);
		c.add(10);
		Collection<ByReconcileDepart> listByIds = service.listByIds(c);
		return listByIds;
	}
	
	@GetMapping("/getIndex2")
	public Object getIndex2() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("scenes_name", "大型自助机");
		Collection<ByReconcileDepart> listByMap = service.listByMap(map);
		return listByMap;
	}

}
