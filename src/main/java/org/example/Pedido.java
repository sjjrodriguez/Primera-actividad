package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int contador = 1;
    private int id;
    private List<Producto> productos;
    private EstadoPedido estado;

    public Pedido() {
        this.id = contador++;
        this.productos = new ArrayList<>();
        this.estado = EstadoPedido.CREADO;
    }

    public int getId() {
        return id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    public void pagar() {
        if (estado == EstadoPedido.CREADO) {
            estado = EstadoPedido.PAGADO;
        }
    }

    public void cancelar() {
        if (estado == EstadoPedido.CREADO || estado == EstadoPedido.PAGADO) {
            estado = EstadoPedido.CANCELADO;
        }
    }

    @Override
    public String toString() {
        return "Pedido #" + id +
                " | Estado: " + estado +
                " | Total: $" + calcularTotal();
    }
}