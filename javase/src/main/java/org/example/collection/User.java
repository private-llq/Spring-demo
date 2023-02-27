package org.example.collection;

/**
 * @author liuliangqi
 * @date 2023/2/24 10:47
 */
public class User {
    private String name;

    public User() {
    }

    public User(String llq) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
