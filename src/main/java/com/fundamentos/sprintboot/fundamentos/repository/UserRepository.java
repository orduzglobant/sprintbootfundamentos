package com.fundamentos.sprintboot.fundamentos.repository;

import com.fundamentos.sprintboot.fundamentos.dto.UserDto;
import com.fundamentos.sprintboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String Email, String name);

    List<User> findByNameLikeOrderByIdAsc(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate birthDateStart, LocalDate birthDateEnd);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query(value = "SELECT new com.fundamentos.sprintboot.fundamentos.dto.UserDto(u.id, u.name, u.birthDate) " +
            "FROM User u " +
            "WHERE " +
            "u.birthDate = :parameterBirthDate " +
            "AND u.email = :parameterEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parameterBirthDate") LocalDate localDate,@Param("parameterEmail") String email);












}
