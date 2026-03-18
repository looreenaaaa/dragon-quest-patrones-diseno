package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class MeteoroAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Meteoro", 120, AttackType.SPECIAL);
    }
}
