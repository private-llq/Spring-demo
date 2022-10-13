//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springimport.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ObjectMapper {
    private static final Logger log = LoggerFactory.getLogger(ObjectMapper.class);
    private static Gson gson = create();

    public ObjectMapper() {
    }

    private static Gson create() {
        JsonSerializer<Date> ser = (src, typeOfSrc, context) -> {
            return src == null ? null : new JsonPrimitive(src.getTime());
        };
        JsonDeserializer<Date> deSer = (json, typeOfT, context) -> {
            return json == null ? null : new Date(json.getAsLong());
        };
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BigDecimal.class, new BigDecimalTypeAdapter());
        builder.registerTypeAdapter(Double.class, new DoubleTypeAdapter());
        builder.registerTypeAdapter(Integer.class, new IntegerTypeAdapter());
        builder.registerTypeAdapter(Long.class, new LongTypeAdapter());
        builder.registerTypeAdapter(Date.class, ser);
        builder.registerTypeAdapter(Date.class, deSer);
        return builder.create();
    }

    public static String toJson(Object instance) {
        return gson.toJson(instance);
    }

    public static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T convert(Object source, Class<T> target) {
        return fromJson(toJson(source), target);
    }

    public static <T> T convert(Object source, Type type) {
        return fromJson(toJson(source), type);
    }

    public static <T> List<T> clone(List<?> source, Class<T> targetClass) {
        ArrayList<T> list = new ArrayList();
        Iterator var3 = source.iterator();

        while(var3.hasNext()) {
            Object s = var3.next();
            T target = clone(s, targetClass);
            clone(s, target);
            list.add(target);
        }

        return list;
    }

    public static <T> T clone(Object source, Class<T> targetClass) {
        Object target = null;

        try {
            target = targetClass.newInstance();
            clone(source, target);
        } catch (Exception var4) {
            log.error(var4.getMessage(), var4);
        }

        return (T) target;
    }

    public static void clone(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    public static Field getField(String name, Class clazz) {
        return ReflectionUtils.findField(clazz, name);
    }

    public static void translate(List<?> source, List<?> target, String requestFieldName, String responseFieldName) {
        translate(source, target, requestFieldName, responseFieldName, "id", "name");
    }

    public static void translate(List<?> source, List<?> target, String requestFieldName, String responseFieldName, String matchKeyFieldName, String matchContentFieldName) {
        if (source != null && source.size() != 0) {
            if (target != null && target.size() != 0) {
                Iterator var6 = target.iterator();

                while(var6.hasNext()) {
                    Object t = var6.next();
                    translate(source, t, requestFieldName, responseFieldName, matchKeyFieldName, matchContentFieldName);
                }

            }
        }
    }

    public static void translate(List<?> source, Object target, String requestFieldName, String responseFieldName) {
        translate(source, target, requestFieldName, responseFieldName, "id", "name");
    }

    public static void translate(List<?> source, Object target, String requestFieldName, String responseFieldName, String matchKeyFieldName, String matchContentFieldName) {
        if (source != null && source.size() != 0) {
            if (target != null) {
                try {
                    Class<?> targetClass = target.getClass();
                    Field requestField = getField(requestFieldName, targetClass);
                    if (requestField == null) {
                        return;
                    }

                    requestField.setAccessible(true);
                    Object requestFieldValue = requestField.get(target);
                    if (requestFieldValue == null) {
                        return;
                    }

                    Field responseField = getField(responseFieldName, targetClass);
                    if (responseField == null) {
                        return;
                    }

                    responseField.setAccessible(true);
                    Class<?> sourceClass = source.get(0).getClass();
                    Field matchKeyField = getField(matchKeyFieldName, sourceClass);
                    if (matchKeyField == null) {
                        return;
                    }

                    matchKeyField.setAccessible(true);
                    Field matchContentField = getField(matchContentFieldName, sourceClass);
                    if (matchContentField == null) {
                        return;
                    }

                    matchContentField.setAccessible(true);
                    Iterator var13 = source.iterator();

                    while(var13.hasNext()) {
                        Object s = var13.next();

                        try {
                            Object matchKeyFieldValue = matchKeyField.get(s);
                            if (matchKeyFieldValue != null && matchKeyFieldValue.equals(requestFieldValue)) {
                                responseField.set(target, matchContentField.get(s));
                                break;
                            }
                        } catch (Exception var16) {
                            log.error(var16.getMessage(), var16);
                        }
                    }
                } catch (Exception var17) {
                    log.error(var17.getMessage(), var17);
                }

            }
        }
    }

    public static <T> List<T> find(List<T> source, T t) {
        if (source != null && source.size() != 0) {
            if (t == null) {
                return source;
            } else {
                Class tCalzz = t.getClass();
                Map<String, Object> notNullFiledValue = new HashMap();
                Map<String, Method> notNullFiledRM = new HashMap();
                PropertyDescriptor propertyDescriptor = null;
                String fieldName = null;
                Method readMethod = null;
                Field[] var8 = t.getClass().getDeclaredFields();
                int var9 = var8.length;

                for(int var10 = 0; var10 < var9; ++var10) {
                    Field declaredField = var8[var10];

                    try {
                        fieldName = declaredField.getName();
                        if (!fieldName.equals("serialVersionUID")) {
                            propertyDescriptor = new PropertyDescriptor(fieldName, tCalzz);
                            readMethod = propertyDescriptor.getReadMethod();
                            Object object = readMethod.invoke(t);
                            if (object != null) {
                                notNullFiledValue.put(fieldName, object);
                                notNullFiledRM.put(fieldName, readMethod);
                            }
                        }
                    } catch (Exception var13) {
                        log.error(var13.getMessage(), var13);
                    }
                }

                return notNullFiledValue.size() == 0 ? source : (List)source.stream().filter((item) -> {
                    Iterator var4 = notNullFiledValue.entrySet().iterator();

                    while(var4.hasNext()) {
                        Entry<String, Object> valueEntry = (Entry)var4.next();
                        String fieldName2 = (String)valueEntry.getKey();

                        try {
                            if (!valueEntry.getValue().equals(((Method)notNullFiledRM.get(fieldName2)).invoke(item))) {
                                return false;
                            }
                        } catch (Exception var7) {
                            log.error(var7.getMessage(), var7);
                        }
                    }

                    return true;
                }).collect(Collectors.toList());
            }
        } else {
            return source;
        }
    }

    public static <T> T find(List<T> source, long id) {
        if (source != null && source.size() != 0) {
            if (id < 0L) {
                return null;
            } else {
                Iterator var3 = source.iterator();

                while(var3.hasNext()) {
                    Object item = var3.next();

                    try {
                        Method getIdMethod = item.getClass().getMethod("getId", (Class[])null);
                        long invoke = (Long)getIdMethod.invoke(item, (Object[])null);
                        if (invoke == id) {
                            return (T) item;
                        }
                    } catch (Exception var8) {
                        log.error(var8.getMessage(), var8);
                    }
                }

                return null;
            }
        } else {
            return null;
        }
    }
}
