package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class FireballAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Fireball", 80, AttackType.SPECIAL);
    }
}
