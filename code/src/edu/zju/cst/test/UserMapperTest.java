/**  
 * @Title: UserMapperTest.java
 * @Package edu.zju.cst.test
 * @author Zhao Qian
 */
package edu.zju.cst.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import edu.zju.cst.mapper.UserMapper;
import edu.zju.cst.pojo.User;

/**
 * @author Zhao Qian
 * @date 2018年12月22日
 * @version 1.0
 */
public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws IOException {
		String resource = "MapperConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取mapper接口的代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = null;
		try {
			user = userMapper.findUserById(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user.toString());
		sqlSession.close();
	}
	@Test
	public void testFindUserByUsername() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = null;
		try {
			list = userMapper.findUserByUsername("张");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());

	}
	@Test
	public void testInsertUser() {
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		//获取mapper接口的代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//要添加的数据
		User user = new User();
		user.setUsername("张小明");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("杭州市");
		//通过mapper接口添加用户
		try {
			userMapper.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//提交
		session.commit();
		//关闭session
		session.close();
	}

}
