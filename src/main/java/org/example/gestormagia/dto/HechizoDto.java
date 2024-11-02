package org.example.gestormagia.dto;

public class HechizoDto {
    private Long id;
    private String nombre;
    private String tipo;
    private String descripcion;

    // Constructor vacío
    public HechizoDto() {}

    // Constructor completo
    public HechizoDto(Long id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescripcion() {;return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    // Método toString para facilitar la impresión
    @Override
    public String toString() {
        return "HechizoDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

