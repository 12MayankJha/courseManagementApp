package com.springRest.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springRest.springRest.entities.DatabaseFile;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

}
