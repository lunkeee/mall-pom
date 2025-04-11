package org.example.user.convert;

import org.example.user.entity.User;
import org.example.user.vo.UserEditVO;

public class UserConvert {
    // 使用单例模式
    public static final UserConvert instance = new UserConvert();

    private UserConvert() {}

    /**
     * 将 MemberEditVO 转换为 User 实体
     * @param editVO 编辑视图对象
     * @return User 实体
     */
    public User editVoToEntity(UserEditVO editVO) {
        if (editVO == null) {
            return null;
        }

        User user = new User();
        user.setUsername(editVO.getUserName());
        user.setMobile(editVO.getMobile());

        // 其他字段如 deleted, gmtCreate, gmtModified 由数据库或框架自动处理
        return user;
    }

    /**
     * 可选：将 User 实体转换为 MemberEditVO
     * @param user 实体对象
     * @return MemberEditVO
     */
    public UserEditVO entityToEditVo(User user) {
        if (user == null) {
            return null;
        }

        UserEditVO editVO = new UserEditVO();
        editVO.setUserName(user.getUsername());
        editVO.setMobile(user.getMobile());

        return editVO;
    }
}