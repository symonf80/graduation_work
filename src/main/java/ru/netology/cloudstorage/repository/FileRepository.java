package ru.netology.cloudstorage.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.cloudstorage.entity.Files;
import ru.netology.cloudstorage.entity.Users;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<Files, String> {

    Files findByUserAndFilename(Users user, String filename);

    void removeByUserAndFilename(Users user, String filename);

    List<Files> findAllByUser(Users user, Sort sort);

    @Modifying
    @Query("update Files f set f.filename = :newName where f.filename = :filename and f.user = :user")
    void editFileNameByUser(@Param("user") Users user, @Param("filename") String filename, @Param("newName") String newName);

}
