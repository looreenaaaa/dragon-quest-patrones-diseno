package com.taller.patrones.application;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.HeroClass;
import com.taller.patrones.domain.attachFactory.AttackFactory;
import com.taller.patrones.domain.attachFactory.AttackRegistry;
import com.taller.patrones.infrastructure.combat.CombatEngine;
import com.taller.patrones.infrastructure.persistence.BattleRepository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Caso de uso: gestionar batallas.
 * <p>
 * Nota: Crea sus propias dependencias con new. Cada vez que necesitamos
 * un CombatEngine o BattleRepository, hacemos new aquí.
 */
public class BattleService {

    private final CombatEngine combatEngine = new CombatEngine();
    private final BattleRepository battleRepository = new BattleRepository();
    private final AttackRegistry attackRegistry = new AttackRegistry();

    public static final List<String> PLAYER_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL", "ICE_BEAM", "POISON_STING", "THUNDER");
    public static final List<String> ENEMY_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL");

    public BattleStartResult startBattle(String playerName, String enemyName) {
        Character player = Character.builder()
                .name("Héroe")
                .maxHp(150)
                .attack(25)
                .defense(15)
                .speed(20)
                .heroClass(HeroClass.WARRIOR)
                .equipment("Espada")
                .build();

        Character enemy = Character.builder()
                .name("Dragón")
                .maxHp(120)
                .attack(30)
                .defense(10)
                .speed(15)
                .build();

        Battle battle = new Battle(player, enemy);
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);

        return new BattleStartResult(battleId, battle);
    }

    public Battle getBattle(String battleId) {
        return battleRepository.findById(battleId);
    }

    public void executePlayerAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || !battle.isPlayerTurn()) return;

        AttackFactory attackFactory = attackRegistry.getFactory(attackName);

        Attack attack = combatEngine.createAttack(attackFactory);

        int damage = combatEngine.calculateDamage(battle.getPlayer(), battle.getEnemy(), attack);
        applyDamage(battle, battle.getPlayer(), battle.getEnemy(), damage, attack);
    }

    public void executeEnemyAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || battle.isPlayerTurn()) return;

        AttackFactory attackFactory = attackRegistry.getFactory(attackName);

        Attack attack = combatEngine.createAttack(attackFactory);

        int damage = combatEngine.calculateDamage(battle.getEnemy(), battle.getPlayer(), attack);
        applyDamage(battle, battle.getEnemy(), battle.getPlayer(), damage, attack);
    }

    private void applyDamage(Battle battle, Character attacker, Character defender, int damage, Attack attack) {
        defender.takeDamage(damage);
        String target = defender == battle.getPlayer() ? "player" : "enemy";
        battle.setLastDamage(damage, target);
        battle.log(attacker.getName() + " usa " + attack.getName() + " y hace " + damage + " de daño a " + defender.getName());
        battle.switchTurn();
        if (!defender.isAlive()) {
            battle.finish(attacker.getName());
        }
    }

    public BattleStartResult startBattleFromExternal(String fighter1Name, int fighter1Hp, int fighter1Atk,
                                                     String fighter2Name, int fighter2Hp, int fighter2Atk) {
        Character player = new Character.Builder()
                .name(fighter1Name)
                .maxHp(fighter1Hp)
                .attack(fighter1Atk)
                .speed(10)
                .defense(10)
                .build();

        Character enemy = new Character.Builder()
                .name(fighter2Name)
                .maxHp(fighter2Hp)
                .attack(fighter2Atk)
                .speed(10)
                .defense(10)
                .build();

        Battle battle = new Battle(player, enemy);
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);
        return new BattleStartResult(battleId, battle);
    }

    public record BattleStartResult(String battleId, Battle battle) {}
}
