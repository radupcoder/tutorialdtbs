package com.tutorialdtbs;

import com.hazelcast.config.Config;
import com.hazelcast.config.IndexConfig;
import com.hazelcast.config.IndexType;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.sql.SqlResult;

import java.util.stream.StreamSupport;

public class SqlSortedQuery {

    public static void main(String[] args) {

        HazelcastInstance member = Hazelcast.newHazelcastInstance(new Config());
        IMap<Integer, Company> companyMap = member.getMap("companies");
        companyMap.addIndex(new IndexConfig(IndexType.SORTED, "companyName"));

        companyMap.put(1, new Company("Company name 1", 34));
        companyMap.put(2, new Company("Company name 2", 59));
        companyMap.put(3, new Company("Company name 3", 12));
        companyMap.put(4, new Company("Company name 4", 3));
        companyMap.put(5, new Company("Company name 5", 5));
        companyMap.put(6, new Company("Company name 6", 82));
        companyMap.put(7, new Company("Company name 7", 98));
        companyMap.put(8, new Company("Company name 8", 1088));
        companyMap.put(9, new Company("Company name 9", 4));
        companyMap.put(10, new Company("Company name 0", 18));

        System.out.println("Companies with more than 50 employees:");
        try (SqlResult result = member.getSql().execute("SELECT companyName FROM companies WHERE numberOfEmployees > ? ORDER BY companyName DESC", 50)) {
            StreamSupport.stream(result.spliterator(), false).map(row -> row.getObject(0)).forEach(System.out::println);
        }
    }
}
