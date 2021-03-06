package cn.ling.medicalview.pojo;

public class Hospital {
    private Integer hid;

    private Integer areaid;

    private String hoscode;

    private String hospass;

    private String hospemail;

    private String hospname;

    private String hospaddress;

    private String hospphone;

    private String hospimage;

    private String hospleader;

    private Integer hospstate;

    private Integer hospshow;

    private String hospintr;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getHoscode() {
        return hoscode;
    }

    public void setHoscode(String hoscode) {
        this.hoscode = hoscode == null ? null : hoscode.trim();
    }

    public String getHospass() {
        return hospass;
    }

    public void setHospass(String hospass) {
        this.hospass = hospass == null ? null : hospass.trim();
    }

    public String getHospemail() {
        return hospemail;
    }

    public void setHospemail(String hospemail) {
        this.hospemail = hospemail == null ? null : hospemail.trim();
    }

    public String getHospname() {
        return hospname;
    }

    public void setHospname(String hospname) {
        this.hospname = hospname == null ? null : hospname.trim();
    }

    public String getHospaddress() {
        return hospaddress;
    }

    public void setHospaddress(String hospaddress) {
        this.hospaddress = hospaddress == null ? null : hospaddress.trim();
    }

    public String getHospphone() {
        return hospphone;
    }

    public void setHospphone(String hospphone) {
        this.hospphone = hospphone == null ? null : hospphone.trim();
    }

    public String getHospimage() {
        return hospimage;
    }

    public void setHospimage(String hospimage) {
        this.hospimage = hospimage == null ? null : hospimage.trim();
    }

    public String getHospleader() {
        return hospleader;
    }

    public void setHospleader(String hospleader) {
        this.hospleader = hospleader == null ? null : hospleader.trim();
    }

    public Integer getHospstate() {
        return hospstate;
    }

    public void setHospstate(Integer hospstate) {
        this.hospstate = hospstate;
    }

    public Integer getHospshow() {
        return hospshow;
    }

    public void setHospshow(Integer hospshow) {
        this.hospshow = hospshow;
    }

    public String getHospintr() {
        return hospintr;
    }

    public void setHospintr(String hospintr) {
        this.hospintr = hospintr == null ? null : hospintr.trim();
    }
}