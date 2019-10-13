package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {

        // Open A Session
        Session session = sessionFactory.openSession();

        // Get All Categories With Hibernate Criteria
        List<Category> categories = session.createCriteria(Category.class).list();

        // Close Session
        session.close();

        return categories;

    }


    @Override
    public Category findById(Long id) {
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }


    @Override
    public void save(Category category) {

        // Open A Session
        Session session = sessionFactory.openSession();

        // Begin Transaction
        session.beginTransaction();

        // Save The Category
        session.save(category);

        // Commit The Transaction
        session.getTransaction().commit();

        // Close The Session
        session.close();

    }


    @Override
    public void delete(Category category) {

    }
}
