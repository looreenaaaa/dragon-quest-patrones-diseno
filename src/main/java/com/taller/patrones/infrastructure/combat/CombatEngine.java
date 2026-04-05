package com.taller.patrones.infrastructure.combat;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.attackFactory.AttackFactory;
import com.taller.patrones.domain.damageStrategy.CriticalDamage;
import com.taller.patrones.domain.damageStrategy.NormalDamage;
import com.taller.patrones.domain.damageStrategy.SpecialDamage;
import com.taller.patrones.domain.damageStrategy.StatusDamage;

/**
 * Motor de combate. Calcula daño y crea ataques.
 * <p>
 * Nota: Esta clase crece cada vez que añadimos un ataque nuevo o un tipo de daño distinto.
 */
public class CombatEngine {

    /**
     * Crea un ataque a partir de su nombre.
     * Cada ataque nuevo requiere modificar este método.
     */
    public Attack createAttack(AttackFactory attackFactory) {
        return attackFactory.create(); // Ves qué limpito queda ahora? Métodos de una línea, ifs con sólo una llamada de método dentro...
        //Es lo deseable, no siempre se puede, pero intenta acercarte lo más que puedas a eso
    }

    /**
     * Calcula el daño según el tipo de ataque.
     * Cada fórmula nueva (ej. crítico, veneno con tiempo) requiere modificar este switch.
     */
    public int calculateDamage(Character attacker, Character defender, Attack attack) { // Muy bien
        return switch (attack.getType()) {
            case NORMAL -> new NormalDamage().calculate(attacker, defender, attack);
            case SPECIAL -> new SpecialDamage().calculate(attacker, defender, attack);
            case STATUS -> new StatusDamage().calculate(attacker, defender, attack);
            case CRITICAL -> new CriticalDamage().calculate(attacker, defender, attack);
        };
    }
}
