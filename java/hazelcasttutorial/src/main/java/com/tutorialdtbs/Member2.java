package com.tutorialdtbs;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Member2 {
    public static void main(String[] args) {
        // creating the second cluster member
        HazelcastInstance member = Hazelcast.newHazelcastInstance(new Config());
        // retrieving the Map stored in the cluster
        Map<Integer, String> testMap = member.getMap("testMap");
        testMap.put(3, "test3");
        testMap.put(4, "test4");
        // printing the values
        System.out.println("Map values:");
        testMap.values().forEach(System.out::println);
    }
}
