package org.example.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.user.dto.UserDTO;
import org.example.user.entity.User;
import org.example.user.qry.UserQry;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户
     *
     * @param qry
     * @return
     */
    List<UserDTO> searchUser(@Param("qry") UserQry qry);

}
