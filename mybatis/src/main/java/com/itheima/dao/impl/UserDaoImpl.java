//package com.itheima.dao.impl;
//
//import com.itheima.dao.UserDao;
//import com.itheima.domain.QueryVo;
//import com.itheima.domain.User;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//
//import java.util.List;
//
///**
// * @author ouyangjie
// * @createTime 2020-03-15 19:24
// */
//public class UserDaoImpl implements UserDao {
//
//    private SqlSessionFactory factory;
//
//    public UserDaoImpl(SqlSessionFactory factory) {
//        this.factory=factory;
//    }
//
//    @Override
//    public List<User> findAll() {
//        SqlSession sqlSession=factory.openSession();
//        List<User> users=sqlSession.selectList("com.itheima.dao.UserDao.findAll");
//        sqlSession.close();
//        return users;
//    }
//    //
//
//    @Override
//    public List<User> findAllByAnnotation() {
//        return null;
//    }
//
//    @Override
//    public void save(User user) {
//        SqlSession sqlSession=factory.openSession();
//        //这个需要参数
//        sqlSession.insert("com.itheima.dao.UserDao.save",user);
//        System.out.println(user.getId());
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Override
//    public int update(User user) {
//        return 0;
//    }
//
//    @Override
//    public void delete(Integer userId) {
//
//    }
//
//    @Override
//    public User findById(int userId) {
//        SqlSession sqlSession=factory.openSession();
//       User user= sqlSession.selectOne("com.itheima.dao.UserDao.findById",userId);
//        return user;
//    }
//
//    @Override
//    public List<User> findByName(String username) {
//        return null;
//    }
//
//    @Override
//    public int count() {
//        return 0;
//    }
//
//    @Override
//    public List<User> findByQueryVo(QueryVo vo) {
//        return null;
//    }
//
//    @Override
//    public List<User> findByCondition(User user) {
//        return null;
//    }
//}
