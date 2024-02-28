package com.fatma.university.reposity;

import com.fatma.university.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {


    List<Event>findAllBySourceDepartment_Id(long departmentId);
}
