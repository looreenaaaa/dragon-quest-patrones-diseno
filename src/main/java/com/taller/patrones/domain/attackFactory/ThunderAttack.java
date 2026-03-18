package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

public class ThunderAttack implements AttackFactory {

    @Override
    public Attack create() {
        return new Attack("Thunder", 90, AttackType.SPECIAL);
    }
}
