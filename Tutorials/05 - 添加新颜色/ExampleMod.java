@SpireInitializer
public class ExampleMod implements EditCardsSubscriber, EditStringsSubscriber {
    private static final String MY_CHARACTER_BUTTON = "ExampleModResources/img/char/Character_Button.png";
    private static final String MY_CHARACTER_PORTRAIT = "ExampleModResources/img/char/Character_Portrait.png";
    private static final String BG_ATTACK_512 = "ExampleModResources/img/512/bg_attack_512.png";
    private static final String BG_POWER_512 = "ExampleModResources/img/512/bg_power_512.png";
    private static final String BG_SKILL_512 = "ExampleModResources/img/512/bg_skill_512.png";
    private static final String small_orb = "ExampleModResources/img/char/small_orb.png";
    private static final String BG_ATTACK_1024 = "ExampleModResources/img/1024/bg_attack.png";
    private static final String BG_POWER_1024 = "ExampleModResources/img/1024/bg_power.png";
    private static final String BG_SKILL_1024 = "ExampleModResources/img/1024/bg_skill.png";
    private static final String big_orb = "ExampleModResources/img/char/card_orb.png";
    private static final String energy_orb = "ExampleModResources/img/char/cost_orb.png";
    
    public static final Color MY_COLOR = new Color(79.0F / 255.0F, 185.0F / 255.0F, 9.0F / 255.0F, 1.0F);

    public ExampleMod() {
        BaseMod.subscribe(this);
        BaseMod.addColor(EXAMPLE_CARD, MY_COLOR, MY_COLOR, MY_COLOR,
            MY_COLOR, MY_COLOR, MY_COLOR, MY_COLOR, BG_ATTACK_512,
            BG_SKILL_512, BG_POWER_512, energy_orb, BG_ATTACK_1024,
            BG_SKILL_1024, BG_POWER_1024, big_orb, small_orb
        );
    }

    public static void initialize() {
        new ExampleMod();
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new Strike());
    }

    public void receiveEditStrings() {
        String lang;
        if (Settings.language == GameLanguage.ZHS) {
            lang = "ZHS";
        } else {
            lang = "ENG";
        }
        BaseMod.loadCustomStringsFile(CardStrings.class, "ExampleResources/localization/" + lang + "/cards.json");
    }
}