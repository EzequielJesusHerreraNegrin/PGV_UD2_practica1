# Documentación Técnica: Sincronización de Hilos con `Farmer` y `Client`

---

## **Descripción del Flujo de la Aplicación**

Esta aplicación simula un sistema en el que **agricultores (`Farmer`)** plantan vegetales y **clientes (`Client`)** consumen esos vegetales de una "parcela" compartida (`Crop`). La sincronización entre los hilos se logra mediante los métodos `wait` y `notifyAll`.

---

## **Clases Principales**

### **1. Farmer (`com.salesianoslacuesta.threads.Farmer`)**

#### **Responsabilidad**

Un hilo que:

- Planta vegetales en el recurso compartido (`Crop`).
- Notifica a los clientes cuando hay nuevos vegetales disponibles.

#### **Métodos**

- **`run()`**:
  - Planta `vegetableToSeed` vegetales en la parcela.
  - Cada vegetal tiene un tiempo de "enfriamiento" (`cooldown`) antes de ser plantado.
  - Usa `notifyAll` para despertar a los hilos que esperan consumir vegetales.

---

### **2. Client (`com.salesianoslacuesta.threads.Client`)**

#### **Responsabilidad**

Un hilo que:

- Consume vegetales de la parcela compartida (`Crop`).
- Espera si no hay vegetales disponibles.

#### **Métodos**

- **`run()`**:
  - Consume `vegetableToEat` vegetales.
  - Si la parcela está vacía, el hilo se suspende (`wait`) hasta que un agricultor agregue nuevos vegetales.

---

### **3. Crop (`com.salesianoslacuesta.resources.Crop`)**

#### **Responsabilidad**

Recurso compartido que:

- Almacena los vegetales sembrados en una lista (`vegetableSeeded`).
- Garantiza la sincronización segura entre los hilos mediante `synchronized`.

#### **Métodos**

- **`addNewVegetable(Vegetable newVegetable)`**:
  - Agrega un vegetal a la lista.
  - Si la lista alcanza su capacidad (`CAPACITY`), suspende el hilo hasta que haya espacio disponible.
- **`dropVegetable(Vegetable vegetable)`**:
  - Remueve un vegetal de la lista.
  - Si la lista está vacía, suspende el hilo hasta que haya vegetales disponibles.

---

### **4. Vegetable (`com.salesianoslacuesta.resources.Vegetable`)**

#### **Responsabilidad**

Clase auxiliar que representa un vegetal. Cada vegetal tiene:

- **Nombre**: Escogido aleatoriamente de una lista predefinida (`VEGETABLE_LIST`).
- **Productor**: Nombre del agricultor que lo plantó.
- **Tiempo de Enfriamiento**: Un tiempo aleatorio entre 1 y 4 segundos antes de estar listo.

---

## **Flujo de Ejecución**

1. **Inicio**:

   - Se crean instancias de `Farmer` y `Client`.
   - Los hilos `Farmer` comienzan a ejecutar el método `run()`, plantando vegetales en la parcela.

2. **Farmer (`run`)**:

   - Agrega un vegetal a la lista compartida (`Crop`).
   - Si la lista está llena, el hilo espera (`wait`).
   - Una vez agregado, despierta a los hilos en espera (`notifyAll`).

3. **Client (`run`)**:

   - Intenta consumir un vegetal de la lista.
   - Si la lista está vacía, el hilo espera (`wait`).
   - Una vez consumido, elimina el vegetal y despierta a otros hilos (`notifyAll`).

4. **Sincronización**:
   - Los métodos `addNewVegetable` y `dropVegetable` están sincronizados para evitar condiciones de carrera.

---

## **Mecanismos de Sincronización**

1. **`synchronized`**:

   - Asegura que solo un hilo acceda al recurso compartido (`Crop`) a la vez.

2. **`wait` y `notifyAll`**:
   - `wait`: Suspende un hilo cuando no puede continuar (por ejemplo, si la lista está llena o vacía).
   - `notifyAll`: Despierta a los hilos suspendidos cuando cambian las condiciones.

---
