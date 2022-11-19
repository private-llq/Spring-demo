package com.example.springimport.doc;

import org.yaml.snakeyaml.Yaml;
 
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
 
public class YamlUtil {

    private static LinkedHashMap<String, Map<String, String>> properties;


    public static void getYamlMap(String yamlName) {
        InputStream in = null;
        try {
            Yaml yaml = new Yaml();
            in = YamlUtil.class.getClassLoader().getResourceAsStream(yamlName);
            properties = yaml.loadAs(in, LinkedHashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getValueByKey(String yamlName, String root, String key) {
        getYamlMap(yamlName);
        String value = null;
        if (root.equals(key)) {
            Iterator it = properties.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (key.equals(entry.getKey())) {
                    value = (String) entry.getValue();
                    break;
                }
            }
        } else {
            LinkedHashMap<String, String> rootProperty = (LinkedHashMap<String, String>) properties.get(root);
            value = iter(rootProperty, key);

        }
        return value;
    }

    public static String iter(LinkedHashMap<String, String> rootProperty, String key) {
        Iterator it = rootProperty.entrySet().iterator();
        String value = null;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (key.equals(entry.getKey())) {

                return (String) entry.getValue();
            }
            if (!(entry.getValue() instanceof LinkedHashMap)) {
                continue;
            }
            value = iter((LinkedHashMap<String, String>) entry.getValue(), key);
            if (value != null) {
                break;
            }
        }
        return value;
    }
}