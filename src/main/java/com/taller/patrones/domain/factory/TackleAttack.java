package com.taller.patrones.domain.factory;

import com.taller.patrones.domain.Attack;

public class TackleAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Tackle", 40, Attack.AttackType.NORMAL);
    }
}
