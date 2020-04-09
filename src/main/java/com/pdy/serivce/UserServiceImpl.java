package com.pdy.serivce;

import com.pdy.entity.User;
import com.pdy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: pdy
 * @Date: 2020/4/2 11:41
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    /**
     * 保存
     */
    public void save(User user){
        userMapper.save(user);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    public User get(Long id){
        return userMapper.get(id);
    }

}
