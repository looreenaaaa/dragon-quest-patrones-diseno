package com.taller.patrones.domain.attackFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * No está mal hacer una clase intermedia para gestionar tus factories, aunque ten en cuenta que puedes poner esto en
 * el BattleService como hice yo ya que tienen relación. Lo que no sé es si el nombre de la clase se entiende... Tampoco
 * sé qué le pondría yo... Quizá un AttackFactoryHandler? Un nombre que incluya AttackFactory seguro
 */
public class AttackRegistry {
    private final Map<String, AttackFactory> registry = new HashMap<>();

    public AttackRegistry() {
        registry.put("TACKLE", new TackleAttackFactory());
        registry.put("SLASH", new SlashAttackFactory());
        registry.put("FIREBALL", new FireballAttackFactory());
        registry.put("ICE_BEAM", new IceBeamAttackFactory());
        registry.put("POISON_STING", new PoisonStingAttackFactory());
        registry.put("THUNDER", new ThunderAttackFactory());
        registry.put("METEORO", new MeteoroAttackFactory());
        registry.put("NORMAL", new NormalAttackFactory());
    }

    public AttackFactory getFactory(String attackName) {
        String name = attackName != null ? attackName.toUpperCase() : "TACKLE";
        return registry.getOrDefault(name, new TackleAttackFactory());
    }
}
