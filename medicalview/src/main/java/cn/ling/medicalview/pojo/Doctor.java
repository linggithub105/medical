package cn.ling.medicalview.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Doctor implements Serializable {
    private Integer did;

    private Integer hid;//医院id

    private Integer oid;//科室名称

    private String doctcode;

    private String doctname;

    private String doctsex;

    private Date doctbitrh;

    private String doctphone;

    private String appellation;

    private String doctemail;

    private String doctintr;//个人简历图片 .jpg

    private String doctimage;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date entrydate;//入职时间

    private Office office;//科室对象
}