package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class TackleAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Tackle", 40, AttackType.NORMAL);
    }
}
