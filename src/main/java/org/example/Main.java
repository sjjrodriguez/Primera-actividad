package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente("Juan");

        Producto p1 = new Producto("Laptop", 3000);
        Producto p2 = new Producto("Mouse", 100);
        Producto p3 = new Producto("Teclado", 150);

        int opcion;

        do {
            System.out.println("\n=== MENÚ TIENDA ONLINE ===");
            System.out.println("1. Realizar pedido");
            System.out.println("2. Ver pedidos");
            System.out.println("3. Devolver (cancelar) pedido");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            // Usando la nueva sintaxis de Switch (Java 14+)
            switch (opcion) {
                case 1 -> {
                    Pedido pedido = cliente.crearPedido();
                    pedido.agregarProducto(p1);
                    pedido.agregarProducto(p2);
                    pedido.agregarProducto(p3);
                    pedido.pagar();
                    System.out.println("Pedido creado correctamente:");
                    System.out.println(pedido);
                }
                case 2 -> {
                    System.out.println("\n--- Pedidos del cliente ---");
                    if (cliente.getPedidos().isEmpty()) {
                        System.out.println("No hay pedidos.");
                    } else {
                        for (Pedido p : cliente.getPedidos()) {
                            System.out.println(p);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese ID del pedido a devolver: ");
                    int id = sc.nextInt();
                    Pedido p = cliente.buscarPedido(id);
                    if (p != null) {
                        p.cancelar();
                        System.out.println("Pedido cancelado.");
                    } else {
                        System.out.println("Pedido no encontrado.");
                    }
                }
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}