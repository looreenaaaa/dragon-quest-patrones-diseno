package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class SlashAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Slash", 55, AttackType.NORMAL);
    }
}
