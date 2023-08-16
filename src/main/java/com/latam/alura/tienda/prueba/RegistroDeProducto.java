package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung", "telefono usado", new BigDecimal("1000"), celulares); //como el tipo del precio era BigDecimal se debio importar para escribir el precio
			 
		EntityManager em = JPAUtils.getEntityManager();	 //Metodo getEntityManager creado en JPAUtils, Mantener la conexion de los DAOS para evitar la duplicacion de codigo, ya que ellos lo pueden utilizar.
		
		ProductoDao productoDao = new ProductoDao(em); //se le pasa el parametro em que es el EntityManager
		CategoriaDao categoriaDao = new CategoriaDao(em);
				
		em.getTransaction().begin(); //indicarle para que deben iniciar las transacciones
		
		categoriaDao.guardar(celulares);//Guarda la instancia celulares que son las categorias antes que el producto ya que el producto esta relacionado con categoria.
		productoDao.guardar(celular); //Realizar la 1ra. Persistencia. Guarda el producto utilizando ProductoDao
		
		em.getTransaction().commit(); //obtenemos la transaccion y realizamos un commit, El commit envia los valores que fueron configurados, los envia a la BD
		em.close();
		
	}

}



