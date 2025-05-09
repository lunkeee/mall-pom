package org.example.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.modules.DTO.UserDTO;
import org.example.modules.DO.User;
import org.example.mapper.UserMapper;
import org.example.modules.DTO.UserQry;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Repository
public class UserDaoImpl extends ServiceImpl<UserMapper, User> implements UserDao {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserDTO> searchUser(UserQry qry) {
        return userMapper.searchUser(qry);
    }
}