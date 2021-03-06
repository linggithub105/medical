package cn.ling.medical;

import cn.ling.medicalview.Listener.ModelDoctorExcelListener;
import cn.ling.medicalview.dto.ExcelDoctorMode;
import com.alibaba.excel.EasyExcel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalviewApplicationTest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setMockMvc(){
		mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void findAllUserTest() throws Exception {
		MockHttpServletRequestBuilder mc= MockMvcRequestBuilders.get("/search/{uid}","1").contentType(MediaType.APPLICATION_JSON_UTF8);
		mockMvc.perform(mc).andDo(MockMvcResultHandlers.print());
	}
}
