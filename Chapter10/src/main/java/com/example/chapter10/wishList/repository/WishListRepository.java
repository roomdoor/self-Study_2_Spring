package com.example.chapter10.wishList.repository;

import com.example.chapter10.db.MemoryDbRepositoryAbstract;
import com.example.chapter10.wishList.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {

}
