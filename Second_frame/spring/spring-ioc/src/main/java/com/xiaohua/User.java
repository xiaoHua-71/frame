package com.xiaohua;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @description: 好好学Java，早日找到好工作
 * @author: XiaoHua
 * @create: 2024-09-04 11:43
 **/

public class User {
    private  String name;
    private  int age;
    private String[] hobby;
    private List<String> friends;
    private Map<String,Integer> parents;
    private Address address;
    private List<Address> addresses;

    public User() {
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public User(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public List<String> getFriends() {
        return friends;
    }

    public Map<String, Integer> getParents() {
        return parents;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void setParents(Map<String, Integer> parents) {
        this.parents = parents;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", friends=" + friends +
                ", parents=" + parents +
                ", address=" + address +
                '}';
    }
}
