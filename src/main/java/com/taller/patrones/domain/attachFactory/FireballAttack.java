package com.taller.patrones.domain.attachFactory;

import com.taller.patrones.domain.Attack;

public class FireballAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Fireball", 80, Attack.AttackType.SPECIAL);
    }
}
