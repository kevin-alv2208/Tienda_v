package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloDao ArticuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activo) {

        var lista = (List<Articulo>) ArticuloDao.findAll();

        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return ArticuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        ArticuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        ArticuloDao.delete(articulo);
    }
    // Otros metodos
}
