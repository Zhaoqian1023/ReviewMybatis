/**  
 * @Title: MybatisNative.java
 * @Package edu.zju.cst.nativemethod
 * @author Zhao Qian
 */
package edu.zju.cst.nativemethod;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import edu.zju.cst.pojo.User;

/**
 * 原生方式实现
 * @author Zhao Qian
 * @date 2018年12月20日
 * @version 1.0
 */
public class MybatisNative {
	
	@Test
	public void findUserById() {
		//核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = null;
		//文件流
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建会话工厂
		SqlSessionFactory sqlSessionFatory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂获得sqlsession
		SqlSession sqlSession = sqlSessionFatory.openSession();
		//通过sqlsession操作数据库
		/**
		 *  第一个参数为映射文件中statement的id名称(包含命名空间)，
		 * 第二个参数为指定的和映射文件中的parameterType类型的参数
		 */
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user.toString());
		sqlSession.close();
	}

}
