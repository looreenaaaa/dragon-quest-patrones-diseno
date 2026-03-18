package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class PoisonStingAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Poison Sting", 20, AttackType.STATUS);
    }
}
