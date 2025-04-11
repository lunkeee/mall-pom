package org.example.user.service;

import lombok.extern.slf4j.Slf4j;
import org.example.user.dao.UserDao;
import org.example.user.dto.UserDTO;
import org.example.user.entity.User;
import org.example.user.qry.UserQry;
import org.example.user.vo.UserEditVO;
import org.example.user.convert.UserConvert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDaoImpl;

    // 更具id查询用户
    @Override
    public User findById(Long id) {
        return Optional.ofNullable(userDaoImpl.getById(id)).orElseThrow(() -> new RuntimeException("数据不存在"));
    }

    // 用户注册
    @Override
    public Boolean addUser(UserEditVO editVO) {
        User entity = UserConvert.instance.editVoToEntity(editVO);
        return userDaoImpl.save(entity);
    }

    // 搜索用户
    @Override
    public List<UserDTO> searchUser(UserQry qry) {
        return userDaoImpl.searchUser(qry);
    }
}