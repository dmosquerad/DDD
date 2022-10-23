package com.architecture.ddd.infrastructure.repository.jpa.repository.custom.impl;

import com.architecture.ddd.infrastructure.repository.jpa.dao.UserDao;
import com.architecture.ddd.infrastructure.repository.jpa.repository.JpaUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.jpa.repository.custom.JpaCustomUserQueryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;

@Repository(JpaCustomUserQueryRepositoryImpl.BEAN)
@RequiredArgsConstructor
public class JpaCustomUserQueryRepositoryImpl implements JpaCustomUserQueryRepository {

    public final static String BEAN = "jpaCustomUserQueryRepositoryImpl";

    @NonNull
    @PersistenceContext
    EntityManager entityManager;

    @NonNull
    JpaUserQueryRepository jpaUserQueryRepository;

    @Override
    public UserDao findFirstUser() {
        return this.entityManager.createQuery("SELECT user FROM UserDao user", UserDao.class).getResultList().stream().filter(Objects::nonNull).findFirst().get();
    }
}
