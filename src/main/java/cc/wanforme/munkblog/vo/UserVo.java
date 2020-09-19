package cc.wanforme.munkblog.vo;

import java.io.Serializable;

/**
 * <p>
 * 用户表（不实现评论和留言，但是保留）
 * </p>
 *
 * @author wanne
 * @since 2020-09-18
 */
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**昵称*/
    private String name;
    /**用户名*/
    private String username;
    /**类型, 01-博主, 02-访问用户*/
    private String type;
    /**邮箱*/
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", username=" + username +
        ", type=" + type +
        ", email=" + email +
        "}";
    }
}
