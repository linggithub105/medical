package cn.ling.medicalview.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Doctor {
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

    private Date entrydate;//入职时间

    private Office office;//科室对象
}