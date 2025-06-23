package com.our.inventario.service;

import java.util.List;
import com.our.inventario.model.Categoria;
import com.our.inventario.model.repository.CategoriaRepository;
import com.our.inventario.utils.algoritmos.arbolbinario.AbsArbolGeneral;
import com.our.inventario.utils.algoritmos.algcategoria.ArbolCategoria;
import com.our.inventario.utils.algoritmos.algcategoria.ListaTempCategoria;
import com.our.inventario.utils.algoritmos.algcategoria.NodoCategoria;
import com.our.inventario.utils.algoritmos.algcategoria.NodoPilaCategoria;
import com.our.inventario.utils.algoritmos.algcategoria.NodoTempCategoria;
import com.our.inventario.utils.algoritmos.algcategoria.OperacionCategoria;
import com.our.inventario.utils.algoritmos.algcategoria.PilaCategoria;
import com.our.inventario.utils.algoritmos.pilas.AbsPila;
import com.our.inventario.utils.algoritmos.pilas.TipoOperacion;
import com.our.inventario.utils.algoritmos.listaenlazada.AbsListaTemp;

public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public boolean crearCategoria(String nombre, String descripcion) {
        return repo.save(new Categoria(null, nombre, descripcion));
    }

    public List<Categoria> listar() {
        cargarCategoriasEnArbol();
        return repo.findAll();
    }

    private void cargarCategoriasEnArbol() {
        List<Categoria> categorias = repo.findAll();

        AbsArbolGeneral<Categoria, NodoCategoria> arbol = new ArbolCategoria();

        for (Categoria categoria : categorias) {
            arbol.insertar(categoria);
        }
        System.out.println("inorden");
        arbol.inOrdenDesc();
        System.out.println("eliminar");
        arbol.eliminar("Celulares");
        arbol.inOrdenDesc();
        arbol.insertarSinDuplicados(new Categoria(Long.valueOf(10), "Computadoras", "Bonitas"));
        arbol.inOrdenDesc();
        AbsListaTemp<Categoria, NodoTempCategoria> listaTemp = new ListaTempCategoria();
        listaTemp.agregar(new Categoria(Long.valueOf(11), "Cocinas", "Que rico"));
        listaTemp.agregar(new Categoria(Long.valueOf(12), "Ollas", "+ rico"));
        listaTemp.agregar(new Categoria(Long.valueOf(13), "Juegos", "Gaaaa"));
        listaTemp.mostrar();
        listaTemp.eliminar("Cocinas");
        listaTemp.confirmar(arbol);
        arbol.inOrdenDesc();
        Categoria cat = new Categoria(Long.valueOf(14), "ewre", "22");
        Categoria cat2 = new Categoria(Long.valueOf(14), "dsfa", "323");

        AbsPila<OperacionCategoria, NodoPilaCategoria> operaciones = new PilaCategoria();
        operaciones.apilar(new OperacionCategoria(TipoOperacion.AGREGAR, cat, cat2));
        System.out.println("Última operación realizada:");
        System.out.println(operaciones.verCima());

        if (arbol.buscar("Lavadoras")) {
            System.out.println("Lácteos está en el sistema.");
        }
    }
}
