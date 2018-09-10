package test.com.definesys.mpaas.common.http;

import com.definesys.mpaas.common.http.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Response Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 27, 2018</pre>
 */
public class ResponseTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void ok01() throws Exception {
        //Response ok=new Response()
//        Response ok=Response.ok();
//        Map<String,String> data=new HashMap<String,String>();
//        data.put("user","asan");
//        data.put("company","definesys");
//        ok.setData(data);
        Response ok = Response.ok().set("user", "asan")
                .set("company", "definesys")
                .set("email", "jianfenng.zheng@definesys.com");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(ok);
        System.out.println(json);
    }

    @Test
    public void ok02() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("jianfeng");
        list.add("asan");
        list.add("Mr.Zheng");
        Response ok = Response.ok();
        ok.setTable(list);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(ok);
        System.out.println(json);
    }

    @Test
    public void ok03() throws Exception {
        Response ok = Response.ok().addListItem("jianfeng")
                .addListItem("asan")
                .addListItem("Mr.Zheng");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(ok);
        System.out.println(json);
    }

    @Test
    public void error01() throws Exception {
        Response ok = Response.error("系统出错");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(ok);
        System.out.println(json);
    }


} 
