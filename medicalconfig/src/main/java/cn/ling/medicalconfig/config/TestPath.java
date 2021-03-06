package cn.ling.medicalconfig.config;

public class TestPath {
    public static void main(String[] args) {
        System.out.println(TestPath.class.getResource("/").getPath());
    }
}
