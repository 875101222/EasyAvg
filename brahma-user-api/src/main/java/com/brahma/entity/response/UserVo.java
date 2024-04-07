package com.brahma.entity.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import com.brahma.entity.BrahmaException;
import com.brahma.entity.UserDo;

@Getter
@Setter
@Schema(description = "返回用户基本信息")
public class UserVo {
    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "用户名称")
    private String name;

    @Schema(description = "用户手机")
    private String telephone;

    @Schema(description = "用户邮箱")
    private String email;

    public static UserVo buildByDo(UserDo userDo) {
        if (userDo == null) {
            throw new BrahmaException();
        }

        UserVo userVo = new UserVo();
        userVo.setId(userDo.getId());
        userVo.setName(userDo.getName());
        userVo.setTelephone(userDo.getTelephone());
        userVo.setEmail(userDo.getEmail());
        return userVo;
    }
}
