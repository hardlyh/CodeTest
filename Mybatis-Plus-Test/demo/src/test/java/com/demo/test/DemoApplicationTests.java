package com.demo.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.demo.entity.ByReconcileDepart;
import com.demo.service.IByReconcileDepartService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private IByReconcileDepartService service;

	@Test
	public void listByMap() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("scenes_name", "大型自助机");
		Collection<ByReconcileDepart> listByMap = service.listByMap(map);
		System.out.println(listByMap);
	}
	
	@Test
	public void getOne() {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("scenes_name", "大型自助机");
		map.put("platform_mch_id","1540492611");
		map.put("seq",null);
		System.out.println(map);
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		
		// 第二个参数为是否关注map中为null的建, 默认为关注,即会添加seq is null, false 会剔除掉为null的键
		q.allEq(map,false);
		
		// 第二个参数为查询多个是否会报错, 默认为true 会报错,  可手动指定为false,不会报错并且会返回一个
		ByReconcileDepart one = service.getOne(q,false);
		System.out.println(one);
	}
	
	@Test
	public void listGroupBy() {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("scenes_name", "大型自助机");
		map.put("platform_mch_id","1540492611");
		map.put("seq",null);
		System.out.println(map);
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		q.eq("scenes_name", "大型自助机");
		q.groupBy("platform_mch_id");
		
		List<ByReconcileDepart> list = service.list(q);
		System.out.println(list);
	}
	
	@Test
	public void listOrderBy() {
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		q.eq("scenes_name", "大型自助机");
		q.orderByDesc("scenes_name","platform_mch_id");
		
		List<ByReconcileDepart> list = service.list(q);
		System.out.println(list);
	}
	
	

	@Test
	public void listOr() {
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		// 这里注意,默认两个条件是用and连接, 只有手动调用or才会用or,例如下面如果不用条件则是两个and 调用了则是两个or
		q.eq("scenes_name", "大型自助机");
		q.or();
		q.eq("platform_mch_id", "1540492611");
		q.orderByDesc("scenes_name","platform_mch_id");
		
		List<ByReconcileDepart> list = service.list(q);
		System.out.println(list);
	}
	
	@Test
	public void listOrAnd() {
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		// 嵌套查询, where ( scenes_name = ? OR ( ( scenes_name = ? AND scenes_name = ? ) ) )
		q.eq("scenes_name", "大型自助机");
		q.or(i->i.eq("scenes_name", "1").eq("scenes_name", "大型"));
		
		List<ByReconcileDepart> list = service.list(q);
		System.out.println(list);
	}
	
	@Test
	public void listOrAnd2() {
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		// 嵌套查询, where ( scenes_name = ? AND ( ( scenes_name = ? AND scenes_name = ? ) ) )
		q.eq("scenes_name", "大型自助机");
		q.and(i->i.eq("scenes_name", "1").eq("scenes_name", "大型"));
		
		List<ByReconcileDepart> list = service.list(q);
		System.out.println(list);
	}
	
	@Test
	public void listapply() {
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		// 手动拼接sql条件,  有两种形式, 一种为直接写死sql,一种使用占位符, 后面为可变参数 apply(String applySql, Object... params)
		q.apply("seq = 5");
		
		List<ByReconcileDepart> list = service.list(q);
		System.out.println(list);
	}
	
	@Test
	public void listPage() {
		QueryWrapper<ByReconcileDepart> q = new QueryWrapper<ByReconcileDepart>();
		q.eq("scenes_name", "大型自助机");
		
		// 可以整合pagehandler, pom文件注意剔除,  getTotal 获取总条数, 注意配置文件的配置方式
		Page<ByReconcileDepart> startPage = PageHelper.startPage(5, 3);
		List<ByReconcileDepart> list = service.list(q);
		
		long total = startPage.getTotal();
		System.out.println(total);
		System.out.println(list.size());
	}
	
	@Test
	public void version() {
		// 失败的话会返回0  没有其他的提示,
		ByReconcileDepart b = new ByReconcileDepart();
		b.setSeq(1023);
		b.setVersion(3);
		
		boolean updateById = service.updateById(b);
		System.out.println(updateById);
	}
	
	@Test
	public void updateWrapper() {
		// set为设置update set * 的内容,设置where后面的内容和条件选择器一致
		UpdateWrapper<ByReconcileDepart> w = new UpdateWrapper<ByReconcileDepart>();
		w.eq("seq", 5);
		w.set("organization_code", "123");
		w.set("omg", "123");
		
		boolean update = service.update(w);
		System.out.println(update);
	}
	
}
