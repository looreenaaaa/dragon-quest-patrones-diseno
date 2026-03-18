package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class NormalAttack implements AttackFactory {

    @Override
    public Attack create() {
        return new Attack("Golpe", 30, AttackType.NORMAL);
    }
}
