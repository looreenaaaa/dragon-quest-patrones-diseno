package com.taller.patrones.domain.damageStrategy;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

public interface DamageStrategy {
    int calculate(com.taller.patrones.domain.Character attacker, Character defender, Attack attack);
}
