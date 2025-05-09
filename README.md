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
Escala y muestra la imagen en el JLabel principal.
[![image.png](https://i.postimg.cc/Y25pBK85/image.png)](https://postimg.cc/nM18qWy2)

## Navegación
Avanza o retrocede entre las imágenes, con soporte para repetir si loop está activado.
[![image.png](https://i.postimg.cc/mkG6VwN5/image.png)](https://postimg.cc/LYNT8jWt)

## Temporizador
Permite el cambio automático de imágenes cada cierto intervalo.
[![image.png](https://i.postimg.cc/Z5D7XZx3/image.png)](https://postimg.cc/JsZ5Bfg4)

## Drag & Drop
Permite al usuario arrastrar imágenes desde el explorador de archivos directamente al componente.
[![image.png](https://i.postimg.cc/5tC3Gz0d/image.png)](https://postimg.cc/QBj1KH10)

## Métodos configurables
Desde el código

[![image.png](https://i.postimg.cc/25hNFTPP/image.png)](https://postimg.cc/JyrFR37q)

## Desde el editor visual de NetBeans
Permite editar desde la paleta de propiedades del JFrame

[![image.png](https://i.postimg.cc/2Sn00JSF/image.png)](https://postimg.cc/NKf8MdT5)
##  Importar en NetBeans

1. Haz clic derecho en el proyecto.
2. Ve a **Propiedades**.
3. Selecciona **Bibliotecas**.
4. Haz clic en **Agregar JAR/carpeta**.
5. Busca y selecciona el archivo 'componenteGaleriaDeImagenes'
[![image.png](https://i.postimg.cc/bwHYRCxK/image.png)](https://postimg.cc/K1jyG5sN)
6. Por último se importuna las clases en el código que se ocupen y lo añadimos a la paleta.

[![image.png](https://i.postimg.cc/RF3NG1VK/image.png)](https://postimg.cc/Q938dT7d)

# Prueba del componente
Aqui se muestra como se ve el componente implemtado en un **JFrame**

[![image.png](https://i.postimg.cc/BQCQT7cR/image.png)](https://postimg.cc/7ffkDVRN)

El boton agregar imagen nos permite añadir las imagenes que deseamos

[![image.png](https://i.postimg.cc/Hx5TV6kZ/image.png)](https://postimg.cc/KkZ6WrLB)

Buscamos la imagen que deseamos y le damos open

[![image.png](https://i.postimg.cc/Hnd1jHKn/image.png)](https://postimg.cc/62jmmsBx)

Para eliminar las imagenes solo tenemos que presionar el boton que se encuentra del lado derecho y automaticamen sera eliminada.

# Video sobre el uso de la librería
[Ver video sobre el uso de la librería en YouTube](https://youtu.be/XQQLMVNo1p4)

