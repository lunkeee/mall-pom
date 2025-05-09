package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.modules.DO.User;
import org.example.modules.DTO.UserDTO;
import org.example.modules.DTO.UserQry;

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
