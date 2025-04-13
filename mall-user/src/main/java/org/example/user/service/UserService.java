package org.example.user.service;

import org.example.user.dto.UserDTO;
import org.example.user.entity.User;
import org.example.user.qry.UserQry;
import org.example.user.vo.UserEditVO;

import java.util.List;

public interface UserService {
    /**
     * 通过ID查询
     *
     * @param id userId
     * @return User
     */
    User findById(Long id);
    /**
     * 新增用户
     *
     * @param editVO 编辑
     * @return Boolean
     */
    Boolean addUser(UserEditVO editVO);
    /**
     * 查询用户
     *
     * @param qry 查询体
     * @return List<UserDTO>
     */
    List<UserDTO> searchUser(UserQry qry);
}