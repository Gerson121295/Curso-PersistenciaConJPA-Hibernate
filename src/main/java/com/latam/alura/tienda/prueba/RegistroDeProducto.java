package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.modelo.Producto;

public class RegistroDeProducto {
	
	public static void main(String[] args) {
		
		Producto celular = new Producto();
		
		celular.setNombre("Samsung");
		celular.setDescripcion("telefono usado");
		celular.setPrecio(new BigDecimal("1000")); //como el tipo del precio era BigDecimal se debio importar para escribir el precio
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda"); //archivo Persistence con BD: tienda
		EntityManager em = factory.createEntityManager(); //instanciar una clase del tipo EntityManager
		em.getTransaction().begin(); //indicarle para que deben iniciar las transacciones
		em.persist(celular); //realizar la 1ra. Persistencia --> Guardar
		em.getTransaction().commit(); //obtenemos la transaccion y realizamos un commit, El commit envia los valores que fueron configurados, los envia a la BD
		em.close();
		
	}

}



