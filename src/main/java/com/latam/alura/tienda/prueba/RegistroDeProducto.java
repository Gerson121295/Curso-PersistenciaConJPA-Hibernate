package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		
		Producto celular = new Producto("Samsung", "telefono usado", new BigDecimal("1000"), Categoria.CELULARES); //como el tipo del precio era BigDecimal se debio importar para escribir el precio
			 
		EntityManager em = JPAUtils.getEntityManager();	 //Metodo getEntityManager creado en JPAUtils	
		ProductoDao productoDao = new ProductoDao(em); //se le pasa el parametro em que es el EntityManager
		
		em.getTransaction().begin(); //indicarle para que deben iniciar las transacciones
		
		//em.persist(celular); //realizar la 1ra. Persistencia --> Guardar
		productoDao.guardar(celular); //Guarda el producto utilizando ProductoDao
		
		em.getTransaction().commit(); //obtenemos la transaccion y realizamos un commit, El commit envia los valores que fueron configurados, los envia a la BD
		em.close();
		
	}

}



