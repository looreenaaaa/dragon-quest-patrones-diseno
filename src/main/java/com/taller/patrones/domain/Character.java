package com.taller.patrones.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un personaje en combate.
 */
public class Character {

    private String name;
    private int currentHp;
    private int maxHp;
    private int attack;
    private int defense;
    private int speed;

    private String equipment;
    private List<String> buff;
    private List<String> temp;
    private HeroClass heroClass;

    private Character() {}

    public static Builder builder() {
        return new Builder();
    }

    public String getName() { return name; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }

    public String getEquipment() { return equipment; }
    public List<String> getBuff() { return buff; }
    public List<String> getTemp() { return temp; }
    public HeroClass getHeroClass() { return heroClass; }

    public void takeDamage(int damage) {
        this.currentHp = Math.max(0, currentHp - damage);
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public double getHpPercentage() {
        return maxHp > 0 ? (double) currentHp / maxHp * 100 : 0;
    }

    public static class Builder {

        private String name;
        private int maxHp;
        private int attack;
        private int defense;
        private int speed;
        private String equipment;
        private List<String> buff;
        private List<String> temp;
        private HeroClass heroClass;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder maxHp(int maxHp) {
            this.maxHp = maxHp;
            return this;
        }

        public Builder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder defense(int defense) {
            this.defense = defense;
            return this;
        }

        public Builder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder equipment(String equipment) {
            this.equipment = equipment;
            return this;
        }

        public Builder buff(List<String> buff) {
            this.buff = buff;
            return this;
        }

        public Builder temp(List<String> temp) {
            this.temp = temp;
            return this;
        }

        public Builder heroClass(HeroClass heroClass) {
            this.heroClass = heroClass;
            return this;
        }

        public Character build() {
            Character character = new Character();
            character.name = name;
            character.maxHp = maxHp;
            character.currentHp = maxHp;
            character.attack = attack;
            character.defense = defense;
            character.speed = speed;
            character.equipment = equipment;
            character.buff = buff != null ? buff : new ArrayList<>();
            character.temp = temp != null ? temp : new ArrayList<>();
            character.heroClass = heroClass != null ? heroClass : HeroClass.WARRIOR;
            return character;
        }
    }
}
