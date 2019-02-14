package com.probal.h2jpa.repository;

import com.probal.h2jpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by probal on 14/2/19.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    public List<Person> findByName(String name);

}
