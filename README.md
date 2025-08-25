### Escuela Colombiana de Ingeniería

### Arquitecturas de Software – ARSW

#### Taller – programación concurrente, condiciones de carrera y sincronización de hilos.

## 📌 Parte 1: Antes de terminar la clase 

⚙️ Creación, puesta en marcha y coordinación de hilos 

1. Lo primero que se hizo fue cambiar el intervalo, se dejo en 100 millones debido a la capacidad (recomendación del profesor), quedo de la siguiente manera:

<p align="center">
<img width="617" height="290" alt="image" src="https://github.com/user-attachments/assets/6dc05250-ab8b-4acc-9e0b-723156761d12" />
</p>

- Vemos como en la CPU se están usando todos los núcleos debido a la capacidad del computador, lo tiene al 100%: 

<p align="center">
<img width="1183" height="605" alt="image" src="https://github.com/user-attachments/assets/75f47452-55bb-42e5-a9f0-41b54aad5920" />
</p>

2. Para este punto en vez de devolver el programa con un solo hilo teníamos que hacerlo ahora con 3 donde cada uno hará la tercera parte del problema original, entonces creamos los 3 hilos e iniciamos las ejecuciones con Start(), quedo de la siguiente manera:

<p align="center">
<img width="612" height="415" alt="image" src="https://github.com/user-attachments/assets/7e23c7f4-d546-470b-b6d5-120fbe6d8f5d" />
</p>

- Ahora vamos a mirar como termina siendo el uso de los núcleos del equipo, en teoría tendria que ser más rapido, pero como el computador tiene pocos núcleos no se puede evidenciar la diferencia con respecto al uso de los núcleos:

<p align="center">
<img width="1148" height="601" alt="image" src="https://github.com/user-attachments/assets/cd6840af-32fb-4446-bdf5-19d3d642a5a6" />
</p>

3.  Para este punto vamos a crear una clase la cual se llamo **PauseController.java**, esta es responsable de gestionar el estado de pausa y reanudación mediante diferentes metodos, luego  la clase **PrimeFinderThread.java** se modificó para recibir una instancia de **PauseController** y consultar **awaitIfPaused()** en cada iteración, de modo que todos los hilos se detienen de forma segura cuando se activa la pausa y ya en el **Main**  tras iniciar los tres hilos se espera 5 segundos, se llama a **pause()**, se muestra en consola el número de primos encontrados hasta ese momento, y luego se espera a que el usuario presione ENTER para invocar **resumeAll()**. Finalmente, se hace **join()** a los hilos y se imprime el total

- **PauseController.java**:

<p align="center">
<img width="421" height="528" alt="image" src="https://github.com/user-attachments/assets/e4f26246-6137-41fd-ba1f-7638744f042c" />
</p>

- **PrimeFinderThread.java**:

<p align="center">
<img width="626" height="312" alt="image" src="https://github.com/user-attachments/assets/7ba286a7-018e-43c6-9954-235e36e87622" />
</p>

- **Main.java**:

<p align="center">
<img width="598" height="333" alt="image" src="https://github.com/user-attachments/assets/b507ff46-8009-4664-883e-8553b80b5680" />
</p>

De esta manera corremos el programa y vemos como a los 5 segundos se detiene y nos muestra la cantidad de primos hasta el momento: 

<p align="center">
<img width="518" height="316" alt="image" src="https://github.com/user-attachments/assets/28a894ec-1a36-4505-835d-cc356131e654" />
</p>
