package com.taller.patrones.domain.attachFactory;

import com.taller.patrones.domain.Attack;

public class SlashAttack implements AttackFactory{

    @Override
    public Attack create() {
        return new Attack("Slash", 55, Attack.AttackType.NORMAL);
    }
}
