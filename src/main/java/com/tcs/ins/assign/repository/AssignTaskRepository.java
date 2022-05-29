package com.tcs.ins.assign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ins.assign.repository.entity.AssignResource;

@Repository
public interface AssignTaskRepository extends JpaRepository<AssignResource, Long>{

}
