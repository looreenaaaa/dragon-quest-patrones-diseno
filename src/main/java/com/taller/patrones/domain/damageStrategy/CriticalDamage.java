package com.taller.patrones.domain.damageStrategy;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

public class CriticalDamage implements DamageStrategy {
    /**
     * Mira mi método, crees que se entiende mejor?
     * https://github.com/AnaGciaSchz/dragon-quest-patrones/blob/solucion-ana/src/main/java/com/taller/patrones/domain/damageStrategy/CriticalDamageStrategy.java
     */
    @Override
    public int calculate(Character attacker, Character defender, Attack attack) {
        boolean isCritical = Math.random() <= 0.20; // 20% de probabilidad

        if (isCritical) {
            double raw = attacker.getAttack() * 1.5;
            return (int) Math.max(0, raw - defender.getDefense());
        } else {
            return 0;
        }

        /**
         * Está bien, pero queda más elegante poner algo así al principio, en vez de tu if:
         *
         *         if (Math.random() > 0.2) {
         *             return 0; // el ataque falla
         *         }
         *
         * ¿Por qué? Porque ya sabes que si no entra dentro del 20%, es 0. ¿Por qué esperar a hacer todos los cálculos y luego
         * ver si va a valer la pena el tiempo invertido en calcularlo? Esto es una técnica llamada guard clauses, que se usa
         * sobre todo para el manejo de errores, pero también sirve para esto.
         *
         * Ayuda a que los métodos sean más simples y no andar arrastrando comprobaciones que no necesitan cálculos.
         * Te dejo aquí un par de links:
         *
         *https://medium.com/@BasuraRatnayake/clean-code-guard-clauses-796225c83c3e
         * https://refactoring.guru/replace-nested-conditional-with-guard-clauses
         */
    }
}
