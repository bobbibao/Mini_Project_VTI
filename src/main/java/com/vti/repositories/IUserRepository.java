package com.vti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long>{

}
