package cn.ling.medicalview.dto;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * https://www.cnblogs.com/FraserYu/p/11717665.html
 * https://blog.csdn.net/weixin_39214481/article/details/93059074
 * 医生导入  读取Excel
 */
@Data
public class ExcelDoctorMode extends BaseRowModel {
    /**
     * @ExcelProperty 注解，同时使用了 index 属性 (0 代表第一列，以此类推)，该注解同时支持以「列名」name 的方式匹配
     * @ExcelProperty("姓名")
     * private String name
     *
     *  1:如果读取的 Excel 模板信息列固定，这里建议以 index 的形式使用，因为如果用名字去匹配，名字重复，
     *  会导致只有一个字段读取到数据，所以 index 是更稳妥的方式
        2:如果 Excel 模板的列 index 经常有变化，那还是选择 name 方式比较好，不用经常性修改实体的注解 index 数值
     */
    @ExcelProperty(index = 0)
    private String hospitalName;
    @ExcelProperty(index = 1)
    private String officeName;
    @ExcelProperty(index = 2)
    private String name;
    @ExcelProperty(index = 3)
    private String numberID;
    @ExcelProperty(index = 4/*, converter = GenderConverter.class*/)
    private String gender;
    @ExcelProperty(index = 5)
    private String phone;
    @ExcelProperty(index = 6)
    private String appellation;
    @ExcelProperty(index = 7)
    @DateTimeFormat("yyyy-MM-dd")
    private String entryDate;
    @ExcelProperty(index = 8)
    private String email;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberID() {
        return numberID;
    }

    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
