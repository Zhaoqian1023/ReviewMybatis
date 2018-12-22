/**  
 * @Title: UserMapper.java
 * @Package edu.zju.cst.mapper
 * @author Zhao Qian
 */
package edu.zju.cst.mapper;

import java.util.List;

import edu.zju.cst.pojo.User;

/**
 * @author Zhao Qian
 * @date 2018年12月22日
 * @version 1.0
 */
public interface UserMapper {
	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 * @throws Exception  
	 * @throws
	 * @author Zhao Qian
	 * @date 2018年12月22日
	 */
	User findUserById(int id) throws Exception;
	/**
	 * 查询用户列表
	 * @param username
	 * @return
	 * @throws Exception  
	 * @throws
	 * @author Zhao Qian
	 * @date 2018年12月22日
	 */
	List<User> findUserByUsername(String username) throws Exception;
	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exception  
	 * @throws
	 * @author Zhao Qian
	 * @date 2018年12月22日
	 */
	void insertUser(User user)throws Exception;

}
