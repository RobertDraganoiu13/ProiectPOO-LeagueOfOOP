package common;

public final class KnightConstants {
    private KnightConstants() { }
    public static final int KNIGHT_BASE_HP = 900;
    public static final int KNIGHT_BONUS_HP_PER_LEVEL = 80;
    public static final float KNIGHT_BONUS_TERRAIN_PERCENTAGE_MODIFIER = 1.15f;

    public static final int   KNIGHT_ABILITY1_BASE_DAMAGE = 200;
    public static final int   KNIGHT_ABILITY1_LEVEL_BONUS_MODIFIER = 30;
    public static final float KNIGHT_ABILITY1_EXECUTE_PERCENTAGE = 0.2f;
    public static final float KNIGHT_ABILITY1_EXECUTE_PERCENTAGE_BONUS = 0.01f;
    public static final float KNIGHT_ABILITY1_EXECUTE_MAX_PERCENTAGE = 0.4f;
    public static final float KNIGHT_ABILITY1_KNIGHT_MODIFIER = 1.0f;
    public static final float KNIGHT_ABILITY1_PYROMANCER_MODIFIER = 1.1f;
    public static final float KNIGHT_ABILITY1_ROGUE_MODIFIER = 1.15f;
    public static final float KNIGHT_ABILITY1_WIZARD_MODIFIER = 0.8f;

    public static final int   KNIGHT_ABILITY2_BASE_DAMAGE = 100;
    public static final int   KNIGHT_ABILITY2_LEVEL_BONUS_MODIFIER = 40;
    public static final float KNIGHT_ABILITY2_KNIGHT_MODIFIER = 1.2f;
    public static final float KNIGHT_ABILITY2_PYROMANCER_MODIFIER = 0.9f;
    public static final float KNIGHT_ABILITY2_ROGUE_MODIFIER = 0.8f;
    public static final float KNIGHT_ABILITY2_WIZARD_MODIFIER = 1.05f;
    public static final int   KNIGHT_ABILITY2_ROUNDS_INCAPACITATED = 1;

    public static final int KNIGHT_SMALL_LIFE_DIVISOR = 3;
    public static final int KNIGHT_BIG_LIFE_DIVISOR = 2;
    public static final int KNIGHT_STRATEGY1_DIVISOR_FOR_LOST_HP = 5;
    public static final float KNIGHT_STRATEGY1_DAMAGE_MODIFIER = 0.5f;
    public static final int KNIGHT_STRATEGY2_DIVISOR_FOR_WON_HP = 4;
    public static final float KNIGHT_STRATEGY2_DAMAGE_MODIFIER = -0.2f;

}
