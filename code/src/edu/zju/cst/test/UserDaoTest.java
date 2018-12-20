/**  
 * @Title: UserDaoTest.java
 * @Package edu.zju.cst.test
 * @author Zhao Qian
 */
package edu.zju.cst.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import edu.zju.cst.dao.UserDao;
import edu.zju.cst.dao.impl.UserDaoImpl;
import edu.zju.cst.pojo.User;

/**
 * @author Zhao Qian
 * @date 2018年12月20日
 * @version 1.0
 */

public class UserDaoTest {

	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserById() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
