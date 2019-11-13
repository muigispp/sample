package com.muigs.systems.rtgapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muigs.systems.rtgapi.model.user.UserModel;

@Repository
public interface MyRepository extends JpaRepository<UserModel, Long> {

}
