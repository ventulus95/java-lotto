package lotto.view;

import lotto.Lotto;
import lotto.Rank;
import lotto.WinningLottos;

import java.util.List;

public class ResultView {

    public void printWinningStatics(WinningLottos winningLottos) {
        System.out.printf("당첨 통계%n======%n");
        for (Rank rank : Rank.winningRanks()) {
            System.out.printf("%d개 일치 (%d원) - %d개%n", rank.matchingCount(), rank.rewardPrice(),
                    winningLottos.countLottoByWinningNumber(rank.matchingCount()));
        }
    }

    public void printRateOfReturn(double rate) {
        System.out.printf("총 수익률은 %.2f입니다.", rate);
    }

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.numbers());
        }
    }
}