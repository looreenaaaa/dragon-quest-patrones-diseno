package com.taller.patrones.domain.damageStrategy;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

public class CriticalDamage implements DamageStrategy {
    @Override
    public int calculate(Character attacker, Character defender, Attack attack) {
        boolean isCritical = Math.random() <= 0.20; // 20% de probabilidad

        if (isCritical) {
            double raw = attacker.getAttack() * 1.5;
            return (int) Math.max(0, raw - defender.getDefense());
        } else {
            return 0;
        }
    }
}
