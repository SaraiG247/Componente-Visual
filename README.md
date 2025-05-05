# Creacion de un componente visual: Galeria de imagenes
**ComponenteGaleria** es un componente visual personalizado en Java Swing que permite mostrar una galería de imágenes con funciones avanzadas de navegación, carga dinámica, control de repetición, transición automática, escalado y soporte para arrastrar y soltar.
Este componente puede integrarse fácilmente en cualquier aplicación Swing, ofreciendo una experiencia de usuario moderna y configurable.

##  Características

- Navegación por flechas (`<`, `>`) o clic del ratón.
- Escalado automático de imágenes.
- Temporizador configurable para transición automática.
- Barra informativa (posición opcional).
- Agregar/Eliminar imágenes en tiempo de ejecución.
- Soporte para arrastrar y soltar (`Drag & Drop`).
- Permite prevenir imágenes duplicadas.
- Totalmente configurable vía métodos públicos.

# Estructura del codigo

El componente extiende de JPanel y utiliza JLayeredPane para mostrar imágenes y botones de navegación superpuestos.
## Constructor
Inicializa todos los elementos gráficos, como barras de control, botones, y configuraciones iniciales del panel.
[![image.png](https://i.postimg.cc/J0ySdn9s/image.png)](https://postimg.cc/0Kstz85v)

## Agregar Imágenes
Permite al usuario seleccionar una imagen desde el disco para agregarla a la galería.
[![image.png](https://i.postimg.cc/pL04xKRm/image.png)](https://postimg.cc/tsx2NZ1b)

## Mostrar imagen
[![image.png](https://i.postimg.cc/Y25pBK85/image.png)](https://postimg.cc/nM18qWy2)


