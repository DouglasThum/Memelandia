package com.douglas.repository;

import org.springframework.data.repository.CrudRepository;

import com.douglas.entity.Meme;

public interface MemeRepository extends CrudRepository<Meme, Long> {

}
