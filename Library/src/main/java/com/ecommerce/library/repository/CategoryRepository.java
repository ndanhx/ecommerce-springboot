package com.ecommerce.library.repository;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //admin
    @Query("select c from Category c where c.is_activated = true and c.is_deleted = false")
    List<Category> findAllByActivated();

    //customer
    @Query(value = "SELECT new com.ecommerce.library.dto.CategoryDto(c.id, c.name, COUNT(p.id) )  " +
            " FROM Category c " +
            " INNER JOIN Product p ON c.id = p.category.id " +
            " WHERE c.is_activated = true AND c.is_deleted = false " +
            " GROUP BY c.id", nativeQuery = false)
    List<CategoryDto> getCategoryAndSize();

}
