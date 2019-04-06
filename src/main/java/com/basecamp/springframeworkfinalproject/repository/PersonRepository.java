package com.basecamp.springframeworkfinalproject.repository;

import com.basecamp.springframeworkfinalproject.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person , UUID> {


    @Query(value = "SELECT p.uuid , p.name FROM Person p WHERE p.state = ?1")
    List<Person> getAllUuidByStateResult(String state);

    @Query(value = "SELECT p FROM Person p")
    Page<Person> findAllUsersWithPagination(Pageable pageable);
}
