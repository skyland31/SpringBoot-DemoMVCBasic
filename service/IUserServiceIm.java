package com.example.demomvc.service;


import com.example.demomvc.entity.UserEntity;
import com.example.demomvc.respository.UserPaginAndSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class IUserServiceIm {
    @Autowired
    private UserPaginAndSorting UserPaginAndSortingRepository;

    public List<UserEntity> findPaginated(int pageNo, int pageSize,String order) {
        //Pagesize จำนวนที่จะให้แสดงในแต่ละPage , PageNo คือเลขหน้า
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(order).ascending());
        Page<UserEntity> pagedResult = UserPaginAndSortingRepository.findAll(paging);
        return pagedResult.toList();
    }
}


