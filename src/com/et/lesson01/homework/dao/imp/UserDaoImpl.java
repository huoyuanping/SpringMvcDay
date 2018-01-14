package com.et.lesson01.homework.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.et.lesson01.homework.dao.MyDao;
import com.et.lesson01.homework.entity.User;
@Repository
public class UserDaoImpl implements MyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void addUser(String sname) {
		String sql = "insert into userinfo(sname) values('"+sname+"')";
		jdbcTemplate.execute(sql);
	
	}

	public int deleteUser(int id) {
		String sql="delete from userinfo where id="+id;	
		return jdbcTemplate.update(sql);
		
	}

	public List<User> queryUser() {
		String sql="select * from userinfo";

		List<User> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
		return list;
	}

	public int updateUser(String sname, int id) {
		String sql="update userinfo set sname='"+sname+"' where id="+id ;	
		return jdbcTemplate.update(sql);
	}

	

}
