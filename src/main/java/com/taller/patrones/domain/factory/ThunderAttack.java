package com.taller.patrones.domain.factory;

import com.taller.patrones.domain.Attack;

public class ThunderAttack implements AttackFactory {

    @Override
    public Attack create() {
        return new Attack("Thunder", 90, Attack.AttackType.SPECIAL);
    }
}
