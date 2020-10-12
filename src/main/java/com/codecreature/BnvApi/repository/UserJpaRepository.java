package com.codecreature.BnvApi.repository;

import com.codecreature.BnvApi.models.BnvUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserJpaRepository {

        @PersistenceContext
        EntityManager entityManager;

        public List<BnvUser> findAll(){
            TypedQuery<BnvUser> namedQuery = entityManager.createNamedQuery("find_all_users", BnvUser.class);
            return namedQuery.getResultList();
        }

        public BnvUser findById(int id){
            return entityManager.find(BnvUser.class, id);
        }


        public BnvUser loginUser(String username){
            Query query = entityManager.createNamedQuery("find_valid_user");
            query.setParameter("username", username);

            return (BnvUser) query.getSingleResult();
        }


//        public Optional<BnvUser> loginUser(String username, String password){
//            Query query = entityManager.createNamedQuery("find_valid_user");
//            query.setParameter("username", username);
//            query.setParameter("password", password);
//
//            return Optional.ofNullable((BnvUser) query.getSingleResult());
//
//        }

        // insert and update are both handled by merge
        public BnvUser update(BnvUser bnvUser){
            return entityManager.merge(bnvUser);
        }

        public void deleteById(int id){
            BnvUser bnvUser = findById(id);
            entityManager.remove(bnvUser);
        }
}
