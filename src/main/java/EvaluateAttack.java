public class EvaluateAttack implements AttackEffectStrategy {

    private CardType defenseCardType;

    boolean play(Queen targetQueen, Hand targetPlayerHand){
        return false;
    }

    @Override
    public void findPlaceForQueen(Queen targetQueen) {

    }
}
