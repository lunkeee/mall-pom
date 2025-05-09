package org.example.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.modules.DTO.UserDTO;
import org.example.modules.DO.User;
import org.example.modules.DTO.UserQry;
import org.example.user.service.UserService;
import org.example.modules.VO.UserEditVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userServiceImpl;

    @ApiOperation(value = "通过ID查询")
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userServiceImpl.findById(id);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Boolean addUser(@RequestBody @Valid UserEditVO editVO) {
        return userServiceImpl.addUser(editVO);
    }

    @ApiOperation(value = "查询用户")
    @GetMapping("/qry")
    public List<UserDTO> searchUser(UserQry qry) {
        return userServiceImpl.searchUser(qry);
    }
}