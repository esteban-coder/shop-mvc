package pe.estebancoder.solutions.shop.service;

import java.io.IOException;
import java.util.List;

public interface GenericService<Resp, Req> {
    Resp create(Req dto);
    Resp update(Long id, Req dto);
    Resp getById(Long id);
    List<Resp> getAll();
    void delete(Long id);
}
