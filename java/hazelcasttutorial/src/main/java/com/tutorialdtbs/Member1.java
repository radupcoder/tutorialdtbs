package com.tutorialdtbs;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Member1 {
    public static void main(String[] args) {
        // creating the first cluster member
        HazelcastInstance member = Hazelcast.newHazelcastInstance(new Config());
        // creating the Map stored in the cluster
        Map<Integer, String> testMap = member.getMap("testMap");
        testMap.put(1, "test1");
        testMap.put(2, "test2");
    }
}
