package cn.ling.medicalview.pojo;

public class Office {
    private Integer oid;

    private String officename;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOfficename() {
        return officename;
    }

    public void setOfficename(String officename) {
        this.officename = officename == null ? null : officename.trim();
    }
}