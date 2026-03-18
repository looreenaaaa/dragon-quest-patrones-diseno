## Ejercicio 1
- El problema al añadir Meteoro es que hay que modificar la clase `CombatEngine` añadiendo un nuevo `case` en su bloque `switch`. Esto viola directamente el Open/Closed Principle (la O de SOLID).
- Si se piden 10 ataques más, `createAttack` seguirá creciendo. La clase `CombatEngine` se volverá más difícil de leer y estará más propenso a errores cada vez que alguien toque el código.
- El patrón que mejor encaja para resolver este problema es el **Patrón Factory**, porque permite extraer y encapsular la lógica de creación de objetos en una interfaz. Aplicándolo, `CombatEngine` ya no necesita conocer los detalles de cada ataque, lo que permite añadir nuevos ataques al sistema sin tener que tocar el código del motor de combate.
---
- La clase `AttackRegistry` asocia directamente el nombre del ataque con su clase concreta. Permitimos que `BattleController` y `BattleService` se comuniquen de forma limpia usando simples `Strings`.

## Ejercicio 2
- El problema al añadir otro case al switch es que nos obliga a modificar la clase `CombatEngine` y `calculateDamage()`. Esto viola el Open/Closed Principle de SOLID.
- El patrón que mejor encaja para resolver este problema es el **Patrón Strategy**, porque permite extraer cada fórmula de cálculo de daño en su propia clase independiente que implementa una interfaz común.

## Ejercicio 3
- El problema que tiene un constructor con muchos parámetros es que ql código se vuelve ilegible y muy propenso a errores porque es fácil confundir el orden de los argumentos.
- Para que la creación de un `Character` sea legible cuando hay valores por defecto debemos evitar llamar al constructor directamente y usar un objeto intermedio que nos permita encadenar llamadas a métodos descriptivos. Así solo especificamos los valores que queremos cambiar y dejamos que el resto tome los valores por defecto automáticamente.
- El patrón que permite construir objetos complejos paso a paso es el **Patrón Builder**, porque permite crear distintas configuraciones del mismo objeto usando un código fácil de leer y manteniendo la inmutabilidad de la clase principal.
---
- Creación de la clase enum `HeroClass` para guardar los dos tipos de clases: guerrero y mago.
- He cambiado el constructor de `Character` a privado y expuesto el método estático `builder()`, forzando a toda la aplicación a pasar por el Builder para instanciar un personaje, impidiendo que se creen objetos incompletos o inconsistentes.
- Si no provee una clase específica, se asigna `HeroClass.WARRIOR` por defecto.