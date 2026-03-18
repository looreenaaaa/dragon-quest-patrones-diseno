package com.taller.patrones.domain.attachFactory;

import com.taller.patrones.domain.Attack;

public class ThunderAttack implements AttackFactory {

    @Override
    public Attack create() {
        return new Attack("Thunder", 90, Attack.AttackType.SPECIAL);
    }
}
