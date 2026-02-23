package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<Pedido> pedidos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
    }

    public Pedido crearPedido() {
        Pedido pedido = new Pedido();
        pedidos.add(pedido);
        return pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Pedido buscarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}