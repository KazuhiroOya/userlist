package com.oya.userlist;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserlistController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String index(Model model) {
		List<Map<String, Object>> list;
		list = jdbcTemplate.queryForList("select * from user");
		model.addAttribute("users", list);
		return "index";
	}
}
