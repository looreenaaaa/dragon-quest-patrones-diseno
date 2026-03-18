package com.taller.patrones.domain.factory;

import java.util.HashMap;
import java.util.Map;

public class AttackRegistry {
    private final Map<String, AttackFactory> registry = new HashMap<>();

    public AttackRegistry() {
        registry.put("TACKLE", new TackleAttack());
        registry.put("SLASH", new SlashAttack());
        registry.put("FIREBALL", new FireballAttack());
        registry.put("ICE_BEAM", new IceBeamAttack());
        registry.put("POISON_STING", new PoisonStingAttack());
        registry.put("THUNDER", new ThunderAttack());
        registry.put("METEORO", new MeteoroAttack());
        registry.put("NORMAL", new NormalAttack());
    }

    public AttackFactory getFactory(String attackName) {
        String name = attackName != null ? attackName.toUpperCase() : "TACKLE";
        return registry.getOrDefault(name, new TackleAttack());
    }
}
