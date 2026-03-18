package com.taller.patrones.domain.damageStrategy;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

public class StatusDamage implements DamageStrategy {
    @Override
    public int calculate(Character attacker, Character defender, Attack attack) {
        return 0;
    }
}
