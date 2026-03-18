package com.taller.patrones.domain.factory;

import com.taller.patrones.domain.Attack;

public class PoisonStingAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Poison Sting", 20, Attack.AttackType.STATUS);
    }
}
