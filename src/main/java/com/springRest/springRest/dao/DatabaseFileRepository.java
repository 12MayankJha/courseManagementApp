package com.springRest.springRest.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springRest.springRest.entities.DatabaseFile;

@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {
	
	@Query(value = "SELECT category FROM files where category IS NOT NULL", nativeQuery = true)
	public List<String> getAllImageCategories();
	
	public List<DatabaseFile> findByCategory(String category);

}
