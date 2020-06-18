package page_001_020;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.corba.se.impl.encoding.CDROutputObject;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuzhaoxin
 */


public enum EventRuleType {
    ADS_LEARNING(1), //
    DOUPLUS_ROOM_METRIC_MONITOR(2), //
    ANTI_CHEAT(3), //
    DPA_AUDIT(4), //
    BALANCE_NOTIFY(5), //
    AD_AUDIT_RECALL(6), //
    ;

    private static final Map<Integer, EventRuleType> CODE_MAPPING;

    static {
        Map<Integer, EventRuleType> tempCodeMapping = new HashMap<>(values().length);
        for (EventRuleType item : values()) {
            tempCodeMapping.put(item.getCode(), item);
        }
        CODE_MAPPING = Collections.unmodifiableMap(tempCodeMapping);
    }

    private final int code;

    EventRuleType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EventRuleType valueOf(int code) {
        return CODE_MAPPING.get(code);
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(10));
//        final Teacher teacher = new Teacher();
//        teacher.setAge(25);
//        teacher.setName("lzx");
//        List<Student> list = Arrays.asList(new Student("lzx","na"),new Student("ly","nv"));
//        teacher.setList(list);
//        final String s = JSONObject.toJSONString(teacher);
//        System.out.println(s);
//        double a = 1;
//        double b = 3;
//        double c = 0.32;
//        if (a / b - c < 0) {
//            System.out.println("adfasdf");
//        }

//        Jedis jedis = new Jedis("localhost",6379);
//        jedis.set("one","1","NX","EX",10);
//        jedis.set("two","2","NX","EX",10);
//        System.out.println(jedis.get("one"));
//        jedis.renamenx("one","three");
//        System.out.println(jedis.get("three"));
//        jedis.rename("two","three"); //如果rename的新旧key都存在，那就保留旧key的值
//        System.out.println(jedis.get("two"));



        /*ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();

        Long teacher = null;
        objectNode.put("field1", "value1");
        objectNode.put("field2", 123);
        objectNode.put("field3",teacher);
        System.out.println(objectNode.path("field3").isMissingNode());
        System.out.println(objectNode.get("field1"));*/

        Map<Integer,Integer> map1 = new HashMap<>();
        map1.put(1,2);
        map1.put(2,3);


        Map<Integer,Integer> map2 = new HashMap<>();
        map2.put(1,3);
        map2.put(4,5);


        final Map<Integer, Integer> collect = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> value2
                ));


        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }


        final String format = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format);

    }

}


class Teacher {
    private String name;
    private int age;
    private List<Student> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}

class Student {
    private String name;
    private String sex;

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

