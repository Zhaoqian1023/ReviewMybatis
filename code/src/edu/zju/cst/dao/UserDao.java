/**  
 * @Title: UserDao.java
 * @Package edu.zju.cst.dao
 * @author Zhao Qian
 */
package edu.zju.cst.dao;

import edu.zju.cst.pojo.User;

/**
 * @author Zhao Qian
 * @date 2018年12月20日
 * @version 1.0
 */
public interface UserDao {
	
	User findUserById(int id);
	

}
