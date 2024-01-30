package com.fatma.university.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface CrudService<entity,Request,Response> {
    public Response add(Request request) throws IOException;
    public Response update(Request request,long id) throws IOException;
    public entity getById(long id);
    public List<Response> getAll();
    public ResponseEntity<?> deleteById(long id);
    public void checkThisIsFoundORThrowException(long id);
}
