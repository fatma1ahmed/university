package com.fatma.university.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface CrudService<Entity,Request,Response> {
    public Response add(Request request) throws IOException;
    public Response update(Request request,long id) throws IOException;
    public Entity getById(long id);
    public Response getEntityById(long id);
    public List<Response> getAll();
    public ResponseEntity<?> deleteById(long id);
}
