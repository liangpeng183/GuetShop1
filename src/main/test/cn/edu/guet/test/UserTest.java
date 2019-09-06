package cn.edu.guet.test;

import cn.edu.guet.bean.Users;
import cn.edu.guet.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.UUID;

public class UserTest {
    @Test
    public void testAddUser(){
        SqlSessionFactory sqlSessionFactory;
            InputStream in= null;
            try {
                in = Class.forName("cn.edu.guet.dao.impl.UserDaoImpl")
                        .getResourceAsStream("/mybatis-config.xml");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=sqlSessionFactory.openSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        Users user=new Users();
        user.setUsersId(UUID.randomUUID().toString().replace("-",""));
        user.setUsername("lp");
        user.setPassword("lp1234");
        mapper.saveUser(user);
        session.commit();
    }
}