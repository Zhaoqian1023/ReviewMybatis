/**  
 * @Title: UserDaoImpl.java
 * @Package edu.zju.cst.dao.impl
 * @author Zhao Qian
 */
package edu.zju.cst.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import edu.zju.cst.dao.UserDao;
import edu.zju.cst.pojo.User;

/**
 * @author Zhao Qian
 * @date 2018年12月20日
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {
	
	// 需要向dao实现类中注入SqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * <p>Description: </p>
	 * @param sqlSessionFactory
	 */
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}


	/* (non-Javadoc)
	 * @see edu.zju.cst.dao.UserDao#findUserById(int)
	 */
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}

}
