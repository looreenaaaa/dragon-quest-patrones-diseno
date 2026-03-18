package com.taller.patrones.domain.attachFactory;

import com.taller.patrones.domain.Attack;

public class IceBeamAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Ice Beam", 70, Attack.AttackType.SPECIAL);
    }
}
