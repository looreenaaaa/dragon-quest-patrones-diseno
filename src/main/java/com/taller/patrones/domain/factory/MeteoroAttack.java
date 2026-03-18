package com.taller.patrones.domain.factory;

import com.taller.patrones.domain.Attack;

public class MeteoroAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Meteoro", 120, Attack.AttackType.SPECIAL);
    }
}
