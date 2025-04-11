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
     * @param id
     * @return
     */
    User findById(Long id);
    /**
     * 新增用户
     *
     * @param editVO
     * @return
     */
    Boolean addUser(UserEditVO editVO);
    /**
     * 查询用户
     *
     * @param qry
     * @return
     */
    List<UserDTO> searchUser(UserQry qry);
}