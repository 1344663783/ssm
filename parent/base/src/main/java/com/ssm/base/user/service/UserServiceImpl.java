package com.ssm.base.user.service;

import com.ssm.base.common.RedisKeyManagement;
import com.ssm.base.user.mapper.UserMapper;
import com.ssm.base.user.model.User;
import com.ssm.base.user.model.UserExample;
import com.ssm.base.util.BlankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    public void insertUser(final User user) {
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisTemplate.getStringSerializer().serialize(String.format(RedisKeyManagement.MODEL_ID,User.class.getName(),uid()));
                redisTemplate.getValueSerializer().serialize(user);
                return null;
            }
        });
        userMapper.insert(user);
    }

    public List<User> getUserList() {
        return userMapper.selectByExample(null);
    }

    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public User selectUserById(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    public void deleteUser(Integer uid) {
        userMapper.deleteByPrimaryKey(uid);
    }

    public List<User> getUserCondition(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(BlankUtil.isNotBlank(user)){
             criteria.andUnameLike("%" + user.getUname() + "%");
        }
        return userMapper.selectByExample(userExample);
    }

    private Integer uid(){
        return (Integer) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.incr(User.class.getName().getBytes());
            }
        });
    }
}
