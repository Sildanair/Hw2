package task1;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Counter implements Callable<BigInteger>
{
    private BigInteger mult;
    private final BigInteger initialValue;
    private final BigInteger postLastValue;

    public Counter(BigInteger initialValue, BigInteger postLastValue)
    {
        mult = BigInteger.ONE;
        this.initialValue = initialValue;
        this.postLastValue = postLastValue;
    }

    @Override
    public BigInteger call()
    {
        for (BigInteger i = initialValue; i.compareTo(postLastValue) <= 0; i = i.add(BigInteger.ONE))
        {
            mult = mult.multiply(i);
        }
        return mult;
    }

    public BigInteger getMult()
    {
        return mult;
    }
}
