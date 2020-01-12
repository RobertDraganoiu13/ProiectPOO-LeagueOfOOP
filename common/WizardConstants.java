package common;

public final class WizardConstants {
    private WizardConstants() { }
    public static final int WIZARD_BASE_HP = 400;
    public static final int WIZARD_BONUS_HP_PER_LEVEL = 30;
    public static final float WIZARD_BONUS_TERRAIN_PERCENTAGE_MODIFIER = 1.1f;

    public static final float WIZARD_ABILITY1_BASE_PERCENTAGE = 0.2f;
    public static final float WIZARD_ABILITY1_LEVEL_BONUS_PERCENTAGE = 0.05f;
    public static final float WIZARD_ABILITY1_MIN_DAMAGE_PERCENTAGE = 0.3f;
    public static final float WIZARD_ABILITY1_KNIGHT_MODIFIER = 1.2f;
    public static final float WIZARD_ABILITY1_PYROMANCER_MODIFIER = 0.9f;
    public static final float WIZARD_ABILITY1_ROGUE_MODIFIER = 0.8f;
    public static final float WIZARD_ABILITY1_WIZARD_MODIFIER = 1.05f;

    public static final float WIZARD_ABILITY2_BASE_PERCENTAGE = 0.35f;
    public static final float WIZARD_ABILITY2_LEVEL_BONUS_PERCENTAGE = 0.02f;
    public static final float WIZARD_ABILITY2_MAX_PERCENTAGE = 0.7f;
    public static final float WIZARD_ABILITY2_KNIGHT_MODIFIER = 1.4f;
    public static final float WIZARD_ABILITY2_PYROMANCER_MODIFIER = 1.3f;
    public static final float WIZARD_ABILITY2_ROGUE_MODIFIER = 1.2f;

    public static final int WIZARD_SMALL_LIFE_DIVISOR = 4;
    public static final int WIZARD_BIG_LIFE_DIVISOR = 2;
    public static final int WIZARD_STRATEGY1_DIVISOR_FOR_LOST_HP = 10;
    public static final float WIZARD_STRATEGY1_DAMAGE_MODIFIER = 0.6f;
    public static final int WIZARD_STRATEGY2_DIVISOR_FOR_WON_HP = 2;
    public static final float WIZARD_STRATEGY2_DAMAGE_MODIFIER = -0.1f;
}
