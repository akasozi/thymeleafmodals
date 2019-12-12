package io.motionlab.repository;

import org.springframework.data.repository.CrudRepository;

import io.motionlab.model.Nationality;

public interface NationalityRepository extends CrudRepository<Nationality, Integer> {

}
