/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package componentegaleriadeimagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarai
 */

public class ComponenteGaleria extends JPanel {
    private boolean loop = true;
    private boolean escalarImagenes = true;
    private String posicionInfo = "NORTH";
    private boolean mostrarControles = true;
    private boolean mostrarNumero = true;
    private boolean transicionSuave = false;
    private String mensajeSinImagen = "Sin imágenes para mostrar";
    private boolean permitirRepetidas = true;
    private List<ImageIcon> imagenes = new ArrayList<>();
    private int indiceActual = 0;
    private Timer timer;
    private int intervalo = 3000;
    private JLabel etiquetaImagen;
    private JLabel barraInfo;
    private JPanel barraSuperior;
    private JPanel barraInferior;
    private Dimension dimension = new Dimension(500, 400);
    private boolean cambioPorClick = false;
    private boolean mostrarBarraSuperior = true;
    private boolean autoCambio = true;
    private boolean mostrarFlechas = true;
    private JButton btnAnterior, btnSiguiente;
    private JPanel panelCentro;
    private JLayeredPane capaImagen;

    public ComponenteGaleria() {
    setLayout(new BorderLayout());
    setPreferredSize(dimension);
    setBackground(Color.WHITE);

    // Barra superior (información)
    barraSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
    barraInfo = new JLabel("Imagen 0 de 0 | Número de imágenes totales: 0");
    barraSuperior.add(barraInfo);
    add(barraSuperior, BorderLayout.NORTH);

    // Dentro del constructor, reemplaza esta parte:
capaImagen = new JLayeredPane();
capaImagen.setPreferredSize(dimension);

// Imagen en capa base
etiquetaImagen = new JLabel("", JLabel.CENTER);
etiquetaImagen.setBounds(0, 0, dimension.width, dimension.height);
etiquetaImagen.setTransferHandler(new TransferHandler("icon"));
capaImagen.add(etiquetaImagen, JLayeredPane.DEFAULT_LAYER);

// Botón izquierdo (flecha "<")
btnAnterior = new JButton("<");
btnAnterior.setFont(new Font("Arial", Font.BOLD, 36)); // Tamaño grande
btnAnterior.setBounds(0, dimension.height / 2 - 30, 60, 60);
btnAnterior.setFocusPainted(false);
btnAnterior.setBorderPainted(false);
btnAnterior.setContentAreaFilled(false);  // Sin fondo
btnAnterior.setOpaque(false);             // Totalmente transparente
btnAnterior.setForeground(Color.BLACK);   // Flecha negra
btnAnterior.setCursor(new Cursor(Cursor.HAND_CURSOR));
btnAnterior.addActionListener(e -> mostrarAnteriorImagen());
capaImagen.add(btnAnterior, JLayeredPane.PALETTE_LAYER);

// Botón derecho (flecha ">")
btnSiguiente = new JButton(">");
btnSiguiente.setFont(new Font("Arial", Font.BOLD, 36));
btnSiguiente.setBounds(dimension.width - 50, dimension.height / 2 - 30, 60, 60);
btnSiguiente.setFocusPainted(false);
btnSiguiente.setBorderPainted(false);
btnSiguiente.setContentAreaFilled(false);
btnSiguiente.setOpaque(false);
btnSiguiente.setForeground(Color.BLACK);
btnSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR));
btnSiguiente.addActionListener(e -> mostrarSiguienteImagen());
capaImagen.add(btnSiguiente, JLayeredPane.PALETTE_LAYER);

add(capaImagen, BorderLayout.CENTER);
    actualizarVisibilidadFlechas(); // Inicialmente ocultos

    // Barra inferior (botones agregar/eliminar)
    barraInferior = new JPanel();
    JButton btnAgregar = new JButton("Agregar Imagen");
    JButton btnEliminar = new JButton("Eliminar Imagen");
    btnAgregar.addActionListener(e -> seleccionarImagen());
    btnEliminar.addActionListener(e -> eliminarImagenActual());
    barraInferior.add(btnAgregar);
    barraInferior.add(btnEliminar);
    add(barraInferior, BorderLayout.SOUTH);

    // Escucha clics para navegación solo si está habilitada la opción
    etiquetaImagen.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!cambioPorClick || imagenes.isEmpty()) return;
            if (SwingUtilities.isRightMouseButton(e)) {
                mostrarSiguienteImagen();
            } else if (SwingUtilities.isLeftMouseButton(e)) {
                mostrarAnteriorImagen();
            }
        }
    });

    // Drop de imágenes
    new DropTarget(this, DnDConstants.ACTION_COPY, new DropTargetAdapter() {
        public void drop(DropTargetDropEvent dtde) {
            try {
                dtde.acceptDrop(DnDConstants.ACTION_COPY);
                List<File> droppedFiles = (List<File>) dtde.getTransferable()
                        .getTransferData(DataFlavor.javaFileListFlavor);
                for (File file : droppedFiles) {
                    if (file.getName().toLowerCase().matches(".*\\.(jpg|jpeg|png|gif)")) {
                        imagenes.add(new ImageIcon(file.getAbsolutePath()));
                    }
                }
                mostrarImagen(indiceActual);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });

    // Temporizador para cambio automático
    timer = new Timer(intervalo, e -> mostrarSiguienteImagen());
}

// Activa o desactiva los botones de flecha y sincroniza el clic
public void setMostrarFlechas(boolean mostrar) {
    this.mostrarFlechas = mostrar;
    this.cambioPorClick = !mostrar; // Desactiva el clic si se muestran flechas
    actualizarVisibilidadFlechas();
}

// Activa o desactiva navegación por clic y sincroniza las flechas
public void setCambioPorClick(boolean activo) {
    this.cambioPorClick = activo;
    this.mostrarFlechas = !activo; // Desactiva flechas si se activa clic
    actualizarVisibilidadFlechas();
}

// Cambia visibilidad de botones de flechas según configuración actual
private void actualizarVisibilidadFlechas() {
    btnAnterior.setVisible(mostrarFlechas);
    btnSiguiente.setVisible(mostrarFlechas);
}

     // Carga una lista de imágenes externa en la galería
    public void setImagenes(List<ImageIcon> imagenes) {
        this.imagenes = new ArrayList<>(imagenes);
        indiceActual = 0;
        if (!imagenes.isEmpty()) {
            mostrarImagen(indiceActual);
        }
    }
    
    // Cambia el intervalo de tiempo del temporizador
    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
        if (timer != null) timer.setDelay(intervalo);
    }

     // Cambia las dimensiones del área de imagen
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        etiquetaImagen.setPreferredSize(dimension);
        revalidate();
        repaint();
    }
    
    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setEscalarImagenes(boolean escalar) {
        this.escalarImagenes = escalar;
    }

     // Cambia la posición de la barra de información (arriba, abajo o ninguna)
    public void setPosicionInfo(String posicion) {
        this.posicionInfo = posicion.toUpperCase();
        actualizarPosicionBarra();
    }

    public void setMostrarControles(boolean mostrar) {
        this.mostrarControles = mostrar;
        barraInferior.setVisible(mostrar);
    }

    public void setMostrarNumero(boolean mostrarNumero) {
        this.mostrarNumero = mostrarNumero;
        actualizarBarra();
    }

    public void setTransicionSuave(boolean transicion) {
        this.transicionSuave = transicion;
    }

    public void setMensajeSinImagen(String mensaje) {
        this.mensajeSinImagen = mensaje;
    }

    public void setPermitirImagenesRepetidas(boolean permitir) {
        this.permitirRepetidas = permitir;
    }

     // Inicia el temporizador automático para cambiar de imagen
    public void iniciarGaleria() {
        if (autoCambio && !timer.isRunning()) timer.start();
    }

    // Detiene el temporizador automático
    public void detenerGaleria() {
        if (timer.isRunning()) timer.stop();
    }


    public void setMostrarBarraSuperior(boolean mostrar) {
        this.mostrarBarraSuperior = mostrar;
        barraSuperior.setVisible(mostrar);
    }

    public void setAutoCambio(boolean auto) {
        this.autoCambio = auto;
        if (!auto) detenerGaleria();
        else iniciarGaleria();
    }

    // Muestra la imagen siguiente en la galería; si está activado el loop, vuelve al inicio
    private void mostrarSiguienteImagen() {
    if (imagenes.isEmpty()) return;

    if (loop || indiceActual < imagenes.size() - 1) {
        indiceActual = (indiceActual + 1) % imagenes.size();
        mostrarImagen(indiceActual);
        reiniciarTimer(); // Reiniciar el temporizador
    }
}

    // Muestra la imagen anterior; si está activado el loop, vuelve al final
    private void mostrarAnteriorImagen() {
        if (imagenes.isEmpty()) return;

        if (loop || indiceActual > 0) {
            indiceActual = (indiceActual - 1 + imagenes.size()) % imagenes.size();
            mostrarImagen(indiceActual);
            reiniciarTimer(); // Reiniciar el temporizador
        }
    }

    // Reinicia el temporizador, útil cuando el usuario cambia manualmente de imagen
    private void reiniciarTimer() {
        if (autoCambio && timer != null) {
            timer.restart(); // Esto detiene y vuelve a iniciar el temporizador
        }
    }

    // Muestra la imagen en la posición indicada y actualiza la barra informativa
   private void mostrarImagen(int index) {
    if (index >= 0 && index < imagenes.size()) {
        ImageIcon iconoOriginal = imagenes.get(index);
        if (escalarImagenes) {
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                    dimension.width, dimension.height, Image.SCALE_SMOOTH);
            etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
        } else {
            etiquetaImagen.setIcon(iconoOriginal);
        }
        actualizarBarra();
    } else {
        etiquetaImagen.setIcon(null);
        actualizarBarra();
    }
}
 
   // Cambia la ubicación de la barra informativa según la propiedad configurada
   private void actualizarPosicionBarra() {
    remove(barraSuperior);
    remove(barraInferior);

    if ("NORTH".equals(posicionInfo)) {
        add(barraSuperior, BorderLayout.NORTH);
        add(barraInferior, BorderLayout.SOUTH);
    } else if ("SOUTH".equals(posicionInfo)) {
        add(barraSuperior, BorderLayout.SOUTH);
        add(barraInferior, BorderLayout.NORTH);
    } else {
        barraSuperior.setVisible(false);
        add(barraInferior, BorderLayout.SOUTH); // Posición por defecto si no hay barra superior
    }

    revalidate();
    repaint();
}

   // Actualiza el texto de la barra superior con información del índice actual
    private void actualizarBarra() {
    if (imagenes.isEmpty()) {
        barraInfo.setText(mensajeSinImagen);
    } else if (mostrarNumero) {
        barraInfo.setText("Imagen " + (indiceActual + 1) + " de " + imagenes.size()
                + " | Número de imágenes totales: " + imagenes.size());
    } else {
        barraInfo.setText("");
    }
    }

    // Elimina la imagen actual de la galería y actualiza la visualización
    private void eliminarImagenActual() {
        if (!imagenes.isEmpty() && indiceActual >= 0 && indiceActual < imagenes.size()) {
            imagenes.remove(indiceActual);
            if (indiceActual >= imagenes.size()) {
                indiceActual = Math.max(0, imagenes.size() - 1);
            }
            mostrarImagen(indiceActual);
        }
    }

    // Abre un selector de archivos para agregar una nueva imagen a la galería
    private void seleccionarImagen() {
      JFileChooser chooser = new JFileChooser();
      chooser.setDialogTitle("Seleccionar imagen");
      chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));

      if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
          File archivo = chooser.getSelectedFile();
          ImageIcon nuevaImagen = new ImageIcon(archivo.getAbsolutePath());

          if (!permitirRepetidas && contieneImagen(nuevaImagen)) {
              JOptionPane.showMessageDialog(this, "La imagen ya fue agregada.");
              return;
          }

          imagenes.add(nuevaImagen);
          mostrarImagen(imagenes.size() - 1);
      }
  }

    // Verifica si una imagen ya existe en la lista para evitar duplicados
    private boolean contieneImagen(ImageIcon icon) {
        for (ImageIcon img : imagenes) {
            if (img.getDescription() != null &&
                img.getDescription().equals(icon.getDescription())) {
                return true;
            }
        }
        return false;
    }
    
    
}


