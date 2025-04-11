package org.example.user.dao;

import org.example.user.dto.UserDTO;
import org.example.user.entity.User;
import org.example.user.qry.UserQry;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
/**
 * @author 阳光倾洒
 * @description 用户-数据访问层(依赖mybatis-plus),重用mybatis-service提供的CURD方法
 */
public interface UserDao extends IService<User> {
    /**
     * 查询用户
     *
     * @param qry
     * @return
     */
    List<UserDTO> searchUser(UserQry qry);
}
