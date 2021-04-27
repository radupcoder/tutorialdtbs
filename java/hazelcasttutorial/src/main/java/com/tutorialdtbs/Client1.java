package com.tutorialdtbs;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Client1 {
    public static void main(String[] args) {
        // connect to the cluster
        HazelcastInstance client = HazelcastClient.newHazelcastClient(new ClientConfig());
        // retrieving the Map stored in the cluster
        Map testMap = client.getMap("testMap");
        testMap.put(1, "test5");
        testMap.remove(3);
    }
}
