package rocks.chendidi.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String userid;

    private String username;

    private String password;

    private String level;

    private Date createdate;

    private Date deletedate;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getDeletedate() {
        return deletedate;
    }

    public void setDeletedate(Date deletedate) {
        this.deletedate = deletedate;
    }
}