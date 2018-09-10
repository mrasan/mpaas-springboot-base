package test.com.definesys.mpaas.common; 

import com.definesys.mpaas.common.Response;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.HashMap;

/** 
* Response Tester. 
* 
* @author <Authors name> 
* @since <pre>八月 27, 2018</pre> 
* @version 1.0 
*/ 
public class ResponseTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sad(String message) 
* 
*/ 
@Test
public void testSad() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setData(Object data) 
* 
*/ 
@Test
public void testSetData() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setList(List<Object> list) 
* 
*/ 
@Test
public void testSetList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addListItem(Object item) 
* 
*/ 
@Test
public void testAddListItem() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setTotal(Long total) 
* 
*/ 
@Test
public void testSetTotalTotal() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: ok() 
* 
*/ 
@Test
public void testOk() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: set(String field, String value) 
* 
*/ 
@Test
public void testSet() throws Exception {
    Response res=Response.ok().set("wo","xxxx");
    HashMap params=new HashMap<String,String>();
    params.put("name","jianfeng");
    res.setData(params);
    res.set("wo","xxxx");
    System.out.println(res.getData());
} 


} 
