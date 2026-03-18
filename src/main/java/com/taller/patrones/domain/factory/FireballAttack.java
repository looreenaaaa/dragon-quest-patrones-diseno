package com.taller.patrones.domain.factory;

import com.taller.patrones.domain.Attack;

public class FireballAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Fireball", 80, Attack.AttackType.SPECIAL);
    }
}
