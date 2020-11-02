package com.example.demomvc.respository;

import com.example.demomvc.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaginAndSorting extends PagingAndSortingRepository<UserEntity, Integer> {

}