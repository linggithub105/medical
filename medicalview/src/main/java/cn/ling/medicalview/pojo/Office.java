package cn.ling.medicalview.pojo;

import lombok.Data;

@Data
public class Office {
    private Integer oid;

    private String officename;

    public void setOfficename(String officename) {
        this.officename = officename == null ? null : officename.trim();
    }
}