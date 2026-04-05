package com.taller.patrones.domain.attackFactory;

import com.taller.patrones.domain.Attack;

public interface AttackFactory {
    Attack create(); // No está mal el nombre del método, yo lo llamé createAttack pero puede ser redundante
}
