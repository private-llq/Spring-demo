package generator.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户 
 * @TableName users
 */
@TableName(value ="users")
@Data
public class Users implements Serializable {
    /**
     * 主键id 用户id
     */
    @TableId
    private Integer user_id;

    /**
     * 用户名 用户名
     */
    private String username;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 昵称 昵称
     */
    private String nickname;

    /**
     * 真实姓名 真实姓名
     */
    private String realname;

    /**
     * 头像 头像
     */
    private String user_img;

    /**
     * 手机号 手机号
     */
    private String user_mobile;

    /**
     * 邮箱地址 邮箱地址
     */
    private String user_email;

    /**
     * 性别 M(男) or F(女)
     */
    private String user_sex;

    /**
     * 生日 生日
     */
    private Date user_birth;

    /**
     * 注册时间 创建时间
     */
    private Date user_regtime;

    /**
     * 更新时间 更新时间
     */
    private Date user_modtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Users other = (Users) that;
        return (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getUser_img() == null ? other.getUser_img() == null : this.getUser_img().equals(other.getUser_img()))
            && (this.getUser_mobile() == null ? other.getUser_mobile() == null : this.getUser_mobile().equals(other.getUser_mobile()))
            && (this.getUser_email() == null ? other.getUser_email() == null : this.getUser_email().equals(other.getUser_email()))
            && (this.getUser_sex() == null ? other.getUser_sex() == null : this.getUser_sex().equals(other.getUser_sex()))
            && (this.getUser_birth() == null ? other.getUser_birth() == null : this.getUser_birth().equals(other.getUser_birth()))
            && (this.getUser_regtime() == null ? other.getUser_regtime() == null : this.getUser_regtime().equals(other.getUser_regtime()))
            && (this.getUser_modtime() == null ? other.getUser_modtime() == null : this.getUser_modtime().equals(other.getUser_modtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getUser_img() == null) ? 0 : getUser_img().hashCode());
        result = prime * result + ((getUser_mobile() == null) ? 0 : getUser_mobile().hashCode());
        result = prime * result + ((getUser_email() == null) ? 0 : getUser_email().hashCode());
        result = prime * result + ((getUser_sex() == null) ? 0 : getUser_sex().hashCode());
        result = prime * result + ((getUser_birth() == null) ? 0 : getUser_birth().hashCode());
        result = prime * result + ((getUser_regtime() == null) ? 0 : getUser_regtime().hashCode());
        result = prime * result + ((getUser_modtime() == null) ? 0 : getUser_modtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_id=").append(user_id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", realname=").append(realname);
        sb.append(", user_img=").append(user_img);
        sb.append(", user_mobile=").append(user_mobile);
        sb.append(", user_email=").append(user_email);
        sb.append(", user_sex=").append(user_sex);
        sb.append(", user_birth=").append(user_birth);
        sb.append(", user_regtime=").append(user_regtime);
        sb.append(", user_modtime=").append(user_modtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}