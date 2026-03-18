package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class IceBeamAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Ice Beam", 70, AttackType.SPECIAL);
    }
}
