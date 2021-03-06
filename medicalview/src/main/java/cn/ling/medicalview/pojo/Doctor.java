package cn.ling.medicalview.pojo;

public class Doctor {
    private Integer did;

    private Integer hid;

    private Integer oid;

    private String doctcode;

    private String doctname;

    private String doctsex;

    private Integer doctage;

    private String doctphone;

    private String appellation;

    private String doctemail;

    private String doctintr;

    private String doctimage;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getDoctcode() {
        return doctcode;
    }

    public void setDoctcode(String doctcode) {
        this.doctcode = doctcode == null ? null : doctcode.trim();
    }

    public String getDoctname() {
        return doctname;
    }

    public void setDoctname(String doctname) {
        this.doctname = doctname == null ? null : doctname.trim();
    }

    public String getDoctsex() {
        return doctsex;
    }

    public void setDoctsex(String doctsex) {
        this.doctsex = doctsex == null ? null : doctsex.trim();
    }

    public Integer getDoctage() {
        return doctage;
    }

    public void setDoctage(Integer doctage) {
        this.doctage = doctage;
    }

    public String getDoctphone() {
        return doctphone;
    }

    public void setDoctphone(String doctphone) {
        this.doctphone = doctphone == null ? null : doctphone.trim();
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation == null ? null : appellation.trim();
    }

    public String getDoctemail() {
        return doctemail;
    }

    public void setDoctemail(String doctemail) {
        this.doctemail = doctemail == null ? null : doctemail.trim();
    }

    public String getDoctintr() {
        return doctintr;
    }

    public void setDoctintr(String doctintr) {
        this.doctintr = doctintr == null ? null : doctintr.trim();
    }

    public String getDoctimage() {
        return doctimage;
    }

    public void setDoctimage(String doctimage) {
        this.doctimage = doctimage == null ? null : doctimage.trim();
    }
}