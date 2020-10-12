package com.codecreature.BnvApi.repository;

import com.codecreature.BnvApi.models.BabyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BabyNameJpaRepository extends JpaRepository<BabyName, Long> {
    List<BabyName> findByUsername(String username);


//    @PersistenceContext
//    EntityManager entityManager;



//    public List<BabyName> findAllNamesByUser(String username){
//        TypedQuery<BabyName> namedQuery = entityManager.createNamedQuery("find_names_by_username", BabyName.class);
//        namedQuery.setParameter("username", username);
//        return namedQuery.getResultList();
//    }
//
//    // insert or update
//    public BabyName update(BabyName babyName) {
//        return entityManager.merge(babyName);
//    }
}
