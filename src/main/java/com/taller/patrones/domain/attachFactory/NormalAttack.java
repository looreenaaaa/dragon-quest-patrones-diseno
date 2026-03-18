package com.taller.patrones.domain.attachFactory;

import com.taller.patrones.domain.Attack;

public class NormalAttack implements AttackFactory {

    @Override
    public Attack create() {
        return new Attack("Golpe", 30, Attack.AttackType.NORMAL);
    }
}
