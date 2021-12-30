package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.*;
import tw.com.fcb.mimosa.test.MimosaTest;

@MimosaTest
//spring直接模擬一個mvc環境(網頁,api功能)
@AutoConfigureMockMvc
public class MockMvcTest {

  @Autowired
  MockMvc mvc;

  //物件與joson格式互轉
  @Autowired
  ObjectMapper mapper;

  //直接用了模擬
  @MockBean
  FakeController mock;

  @Test
  void listAll() throws Exception {
    //用mock置換了回傳值
    Mockito.when(mock.listAll()).thenReturn(100);

    var body = mvc.perform(MockMvcRequestBuilders.get("/test")
        .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status()
            .is2xxSuccessful())
        .andReturn()
        .getResponse()
        .getContentAsString();

    //assert body = 100
    Assertions.assertThat(body).isEqualTo("100");

  }

  @Test
  @Disabled
  void echo() throws Exception {
    var name = new Name();
    name.setFirstName("my-name");
    mvc.perform(MockMvcRequestBuilders.post("/test/echo")
        //指定server端要回給我什麼格式
        .accept(MediaType.APPLICATION_JSON)
        //跟server端說我傳入的是什麼格式
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(name)))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
        .andExpect(MockMvcResultMatchers.content().string("Hello" + name.getFirstName()));
  }

  @RestController
  @RequestMapping("/test")
  static class FakeController {

    @GetMapping
    int listAll() {
      return 100;
    }

    @PostMapping("/echo")
    String echo(@RequestBody Name name) {
      return "Hello" + name.getFirstName();
    }

  }

  @Data
  static class Name {
    String firstName;

  }
}
