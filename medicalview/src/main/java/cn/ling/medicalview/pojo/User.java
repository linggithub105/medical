package cn.ling.medicalview.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Calendar;
import java.util.Date;

@TableName("user")//数据库表名
public class User {
    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;
    @TableField(exist = false)
    private Integer lid;//权限id
    @TableField("usercode")
    private String usercode;
    @TableField("userpass")
    private String userpass;
    @TableField("usersex")
    private String usersex;
    @TableField(exist = false)
    private Integer userage;
    @TableField("userphone")
    private String userphone;
    @TableField("useraddress")
    private String useraddress;
    @TableField("usercodeid")
    private String usercodeid;
    @TableField("regdate")
    private Date regdate;
    @TableField("userstate")
    private Integer userstate;
    @TableField("username")
    private String username;
    @TableField("useremail")
    private String useremail;
    @TableField("birthday")
    private Date birthday;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass == null ? null : userpass.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
        if (userage == null && "".equals(userage)) {
            this.userage = getAgeByBirth(birthday);
        }
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress == null ? null : useraddress.trim();
    }

    public String getUsercodeid() {
        return usercodeid;
    }

    public void setUsercodeid(String usercodeid) {
        this.usercodeid = usercodeid == null ? null : usercodeid.trim();
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public User() {
    }

    public User(Integer uid, Integer lid, String usercode, String userpass, String usersex, Integer userage, String userphone, String useraddress, String usercodeid, Date regdate, Integer userstate, String username, String useremail, Date birthday) {
        this.uid = uid;
        this.lid = lid;
        this.usercode = usercode;
        this.userpass = userpass;
        this.usersex = usersex;
        this.userage = userage;
        this.userphone = userphone;
        this.useraddress = useraddress;
        this.usercodeid = usercodeid;
        this.regdate = regdate;
        this.userstate = userstate;
        this.username = username;
        this.useremail = useremail;
        this.birthday = birthday;
    }

    public static int getAgeByBirth(Date birthday) {
        //Calendar：日历
        /*从Calendar对象中或得一个Date对象*/
        Calendar cal = Calendar.getInstance();
        /*把出生日期放入Calendar类型的bir对象中，进行Calendar和Date类型进行转换*/
        Calendar bir = Calendar.getInstance();
        bir.setTime(birthday);
        /*如果生日大于当前日期，则抛出异常：出生日期不能大于当前日期*/
        if (cal.before(birthday)) {
            throw new IllegalArgumentException("The birthday is before Now,It's unbelievable");
        }
        /*取出当前年月日*/
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayNow = cal.get(Calendar.DAY_OF_MONTH);
        /*取出出生年月日*/
        int yearBirth = bir.get(Calendar.YEAR);
        int monthBirth = bir.get(Calendar.MONTH);
        int dayBirth = bir.get(Calendar.DAY_OF_MONTH);
        /*大概年龄是当前年减去出生年*/
        int age = yearNow - yearBirth;
        /*如果出当前月小与出生月，或者当前月等于出生月但是当前日小于出生日，那么年龄age就减一岁*/
        if (monthNow < monthBirth || (monthNow == monthBirth && dayNow < dayBirth)) {
            age--;
        }
        return age;
    }
}