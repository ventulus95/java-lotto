package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private Lotto winningLotto;
    private List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private LottoStatics lottoStatics = new LottoStatics();
    

    public void buyLotto(int price) {
        this.lottos = Stream
            .generate(() -> new Lotto(makingLottoNumbers()))
            .limit(getGameCount(price))
            .collect(Collectors.toList());
    }

    private List<Integer> makingLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return list.subList(0, 6);
    }

    private int getGameCount(int price) {
        if (isValidBuyLottoPrice(price)) {
            throw new IllegalArgumentException();
        }
        return price / LOTTO_PRICE;
    }

    private  boolean isValidBuyLottoPrice(int price) {
        return price % LOTTO_PRICE != 0;
    }

    public int countLotto() {
        return lottos.size();
    }

    public void registerWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public Lotto winningLotto() {
        return winningLotto;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public void classifyRankLotto() {
        lottoStatics.classifyRankLotto(lottos, winningLotto);
    }

    public WinningLottos winningLottos() {
        return lottoStatics.winningLottos();
    }

    public double investingPercent(int price) {
        return (double) lottoStatics.rewardTotalWinningLottos() / price;
    }


}
