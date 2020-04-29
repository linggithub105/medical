package cn.ling.medical2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//扫描接口dao层
@MapperScan("cn.ling.medical2.mapper")
//springBoot核心配置 启动类
@SpringBootApplication
//添加对事务的支持
@EnableTransactionManagement
//开启基于注解的缓存
@EnableCaching
public class Medical2Application {

	public static void main(String[] args) {
		SpringApplication.run(Medical2Application.class, args);
	}

}
