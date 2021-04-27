package com.tutorialdtbs;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Client2 {
    public static void main(String[] args) {
        // connect to the cluster
        HazelcastInstance client = HazelcastClient.newHazelcastClient(new ClientConfig());
        // retrieving the Map stored in the cluster
        Map testMap = client.getMap("testMap");
        // printing the values
        System.out.println("Map values:");
        testMap.values().forEach(System.out::println);
    }
}
