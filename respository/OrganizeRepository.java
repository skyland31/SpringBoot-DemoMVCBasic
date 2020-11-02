
package com.example.demomvc.respository;

import com.example.demomvc.entity.OrganizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizeRepository extends JpaRepository<OrganizeEntity, Integer> {

}
