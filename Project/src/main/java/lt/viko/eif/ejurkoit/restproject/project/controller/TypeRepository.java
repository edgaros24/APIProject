package lt.viko.eif.ejurkoit.restproject.project.controller;

import lt.viko.eif.ejurkoit.restproject.project.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Represents type repository
 * @see Type
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type findById(int typeId);

}
