package com.DMH.accountsservice.repository;

import com.DMH.accountsservice.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String emailFromToken);
    Account findByAlias(String recipientIdentifier);
    Account findByCvu(String recipientIdentifier);
    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.alias = :alias WHERE a.id = :id")
    void updateAlias(@Param("id") Long id, @Param("alias") String alias);
}
