## Ejercicio 1

- El problema al añadir Meteoro es que hay que modificar la clase `CombatEngine` añadiendo un nuevo `case` en su bloque `switch`. Esto viola directamente el Open/Closed Principle (la O de SOLID).
- Si se piden 10 ataques más, `createAttack` seguirá creciendo. La clase `CombatEngine` se volverá más difícil de leer y estará más propenso a errores cada vez que alguien toque el código.
- El patrón que mejor encaja para resolver este problema es el **Patrón Factory**, porque permite extraer y encapsular la lógica de creación de objetos en una interfaz. Aplicándolo, `CombatEngine` ya no necesita conocer los detalles de cada ataque, lo que permite añadir nuevos ataques al sistema sin tener que tocar el código del motor de combate.