package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.AttackType;

/**
 * Si es una Factory, añade esa información en el nombre de la clase por claridad. Si no, parece que esta clase es el propio ataaque,
 * no una clase que crea ataques.
 */
public class IceBeamAttackFactory implements AttackFactory {

    @Override
    public Attack create() {
        return new Attack("Ice Beam", 70, AttackType.SPECIAL);
    }
}
