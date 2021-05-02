package com.tutorialdtbs;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

import java.util.Collection;

public class CriteriaApiQuery {

    public static void main(String[] args) {

        HazelcastInstance member = Hazelcast.newHazelcastInstance(new Config());
        IMap<Integer, Company> companyMap = member.getMap("companies");

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
        Predicate predicate = Predicates.newPredicateBuilder().getEntryObject().get("numberOfEmployees").greaterThan(50);
        Collection<Company> companies = companyMap.values(predicate);
        companies.stream().map(Company::getCompanyName).forEach(System.out::println);

    }

}
