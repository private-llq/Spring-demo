//package org.example.framework.beans.factoy.support.xml;
//
//import org.example.framework.context.support.BeanDefinitionRegistry;
//import org.example.framework.context.support.XmlBeanDefinitionReader;
//
//import java.lang.reflect.Method;
//
///**
// * IOC容器的具体子实现类：用于加载类路径下的xml格式的配置文件
// * @author tt11
// * @create 2022-09-03 20:19
// */
//public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
//
//    public ClassPathXmlApplicationContext(String configLocation) {
//        // 1.设置configLocation
//        this.configLocation = configLocation;
//        // 2.创建 reader 的子实现类对象
//        this.beanDefinitionReader = new XmlBeanDefinitionReader();
//        try {
//            // 3.调用父类的 refresh 方法
//            this.refresh();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Object getBean(String name) throws Exception {
//        // 1.判断容器内是否有此对象
//        Object obj = singletonObjects.get(name);
//        // 2.有就直接返回
//        if (obj != null) {
//            return obj;
//        }
//        // 3.根据注册表得到 beanDefinition 对象
//        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
//        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
//        // 4.若为空，直接返回空
//        if (beanDefinition == null) {
//            return null;
//        }
//        // 5.得到对象的全类名
//        String className = beanDefinition.getClassName();
//        // 6.根据反射得到对象
//        Class<?> clazz = Class.forName(className);
//        Object bean = clazz.newInstance();
//        // 7.返回之前需要设置 Property 对象
//        // 8.由 beanDefinition 得到 MutablePropertyValues（迭代器模式）
//        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
//        // 9.遍历集合
//        for (PropertyValue propertyValue : propertyValues) {
//            // 10.解析 name,ref,value
//            String propertyName = propertyValue.getName();
//            String ref = propertyValue.getRef();
//            String value = propertyValue.getValue();
//            // 11.ref不为空
//            if (ref != null && !"".equals(ref)) {
//                Object propertyBean = getBean(ref);
//                // 11.1 拼接方法名
//                String methodName = StringUtils.getSetterMethodNameByFieldName(propertyName);
//                // 11.1 执行方法
//                Method[] methods = clazz.getMethods();
//                for (Method method : methods) {
//                    if (method.getName().equals(methodName)) {
//                        method.invoke(bean, propertyBean);
//                    }
//                }
//            }
//            // 12.value 不为空
//            if (value != null && !"".equals(value)) {
//                // 12.1 拼接方法
//                String methodName = StringUtils.getSetterMethodNameByFieldName(propertyName);
//                // 12.2 执行方法
//                Method method = clazz.getMethod(methodName, String.class);
//                method.invoke(bean, value);
//            }
//        }
//        // 13.将 bean 加入map容器中
//        singletonObjects.put(name, bean);
//        // 14.返回对象
//        return bean;
//    }
//
//    @Override
//    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
//        Object bean = getBean(name);
//        return clazz.cast(bean);
//    }
//}