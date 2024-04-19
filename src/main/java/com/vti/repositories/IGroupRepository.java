package com.vti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.models.GroupModel;

@Repository
public interface IGroupRepository extends JpaRepository<GroupModel, Long>{

}
