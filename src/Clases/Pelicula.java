/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author anfel
 */
public class Pelicula {
    private String titulo;
    private String posterPath; // Ruta local de la imagen

    public Pelicula(String titulo, String posterPath) {
        this.titulo = titulo;
        this.posterPath = posterPath;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    
    
    
    public void mostrarPeliculas(List<Pelicula> peliculas, JPanel contenedorPeliculas) {
    contenedorPeliculas.removeAll(); // Limpiamos el panel
    contenedorPeliculas.setLayout(new FlowLayout(FlowLayout.LEFT)); // O GridLayout si prefieres

    for (Pelicula peli : peliculas) {
        JPanel panelPelicula = new JPanel();
        panelPelicula.setLayout(new BoxLayout(panelPelicula, BoxLayout.Y_AXIS));
        panelPelicula.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Cargar imagen
        ImageIcon icono = new ImageIcon(peli.getPosterPath());
        Image imagenRedimensionada = icono.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        JLabel lblImagen = new JLabel(new ImageIcon(imagenRedimensionada));

        // Título
        JLabel lblTitulo = new JLabel(peli.getTitulo());
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botón de reserva
        JButton btnReservar = new JButton("Reservar");
        btnReservar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReservar.addActionListener(e -> {
            // Aquí puedes abrir un nuevo JFrame o mostrar un JOptionPane
            JOptionPane.showMessageDialog(null, "Reservaste: " + peli.getTitulo());
        });

        // Agregar al panel individual
        panelPelicula.add(lblImagen);
        panelPelicula.add(Box.createVerticalStrut(10));
        panelPelicula.add(lblTitulo);
        panelPelicula.add(Box.createVerticalStrut(5));
        panelPelicula.add(btnReservar);

        // Agregar al contenedor principal
        contenedorPeliculas.add(panelPelicula);
    }

    contenedorPeliculas.revalidate();
    contenedorPeliculas.repaint();
}


}
