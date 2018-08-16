package yiming.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import yiming.service.ListNotEmpty;
import yiming.validate.Group;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class User {

    @NotNull(message = "userId不能为空", groups = {Group.notNUll1.class})
    private String userId;

    @NotNull(message = "姓名不能为空", groups = {Group.notNull2.class})
    private String userName;

    @NotEmpty(message = "密码不能为空", groups = {Group.notNull2.class,Group.notNUll1.class})
    private String password;

    private Integer status;

    @ListNotEmpty(groups = {Group.notNUll1.class})
    private List<String> lists;

}