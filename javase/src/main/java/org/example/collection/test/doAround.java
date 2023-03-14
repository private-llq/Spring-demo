package org.example.collection.test;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliangqi
 * @date 2023/3/13 10:52
 */
public class doAround {
  @Around("dict()")
  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    Object result = pjp.proceed();
    if (result instanceof ResponseVo) {
      // 重新封装返回对象
      ResponseVo vo = JSONObject.parseObject(JSON.toJSONString(result), ResponseVo.class);
      //        LinkedList<Object> recordsList = new LinkedList<Object>();
      Class<?> aClass = result.getClass();
      Field[] fields1 = aClass.getDeclaredFields();
      for (Field field : fields1) {
        field.setAccessible(true);
        if ("data".equals(field.getName()) && field.get(result) instanceof IPage) {
          Object o = field.get(result);
          JSONObject data = JSONObject.parseObject(JSON.toJSONString(o));
          Class<?> oClass = o.getClass();
          Field[] oClassDeclaredFields = oClass.getDeclaredFields();
          for (Field oClassDeclaredField : oClassDeclaredFields) {
            oClassDeclaredField.setAccessible(true);
            if ("records".equals(oClassDeclaredField.getName())) {
              List<?> o1 = (List<?>) oClassDeclaredField.get(o);
              ArrayList<Object> list1 = new ArrayList<>();
              for (Object o2 : o1) {
                JSONObject object2 = JSONObject.parseObject(JSON.toJSONString(o2));
                Class<?> o1Class = o2.getClass();
                Field[] o1ClassDeclaredFields = o1Class.getDeclaredFields();
                for (Field uu : o1ClassDeclaredFields) {
                  uu.setAccessible(true);
                  // 参数名
                  String name = uu.getName();
//                  Dict dict = uu.getAnnotation(Dict.class);
//                  if (dict != null) {
//                    // 获取到了注解的code,根据code获取字典值
//                  }
//                  String code = dict.value();
//                  System.out.println(code);
                }
              }
            }
          }
        }
      }
    }
    return null;
  }
}
