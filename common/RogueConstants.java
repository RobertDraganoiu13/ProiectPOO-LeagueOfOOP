package common;

public final class RogueConstants {
    private RogueConstants() { }
    public static final int ROGUE_BASE_HP = 600;
    public static final int ROGUE_BONUS_HP_PER_LEVEL = 40;
    public static final float ROGUE_BONUS_TERRAIN_PERCENTAGE_MODIFIER = 1.15f;

    public static final int   ROGUE_ABILITY1_BASE_DAMAGE = 200;
    public static final int   ROGUE_ABILITY1_LEVEL_BONUS_MODIFIER = 20;
    public static final float ROGUE_ABILITY1_KNIGHT_MODIFIER = 0.9f;
    public static final float ROGUE_ABILITY1_PYROMANCER_MODIFIER = 1.25f;
    public static final float ROGUE_ABILITY1_ROGUE_MODIFIER = 1.2f;
    public static final float ROGUE_ABILITY1_WIZARD_MODIFIER = 1.25f;
    public static final float ROGUE_ABILITY1_CRIT_MODIFIER = 1.5f;
    public static final int   ROGUE_ABILITY1_BACKSTAB_ROUNDS = 3;

    public static final int   ROGUE_ABILITY2_BASE_DAMAGE = 40;
    public static final int   ROGUE_ABILITY2_LEVEL_BONUS_MODIFIER = 10;
    public static final int   ROGUE_ABILITY2_ROUNDS_INCAPACITATED = 3;
    public static final float ROGUE_ABILITY2_KNIGHT_MODIFIER = 0.7999f;
    public static final float ROGUE_ABILITY2_PYROMANCER_MODIFIER = 1.2f;
    public static final float ROGUE_ABILITY2_ROGUE_MODIFIER = 0.8999f;
    public static final float ROGUE_ABILITY2_WIZARD_MODIFIER = 1.25f;

    public static final int ROGUE_SMALL_LIFE_DIVISOR = 7;
    public static final int ROGUE_BIG_LIFE_DIVISOR = 5;
    public static final int ROGUE_STRATEGY1_DIVISOR_FOR_LOST_HP = 7;
    public static final float ROGUE_STRATEGY1_DAMAGE_MODIFIER = 0.4f;
    public static final int ROGUE_STRATEGY2_DIVISOR_FOR_WON_HP = 2;
    public static final float ROGUE_STRATEGY2_DAMAGE_MODIFIER = -0.1f;
}
