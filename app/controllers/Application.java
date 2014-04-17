
package controllers;

import java.util.Random;

import javax.annotation.Nullable;

import play.libs.F.Function;
import play.libs.F.Function0;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
    public static Promise<Result> index(@Nullable final Integer delay) {
        Promise<Integer> promiseOfInt = Promise.promise(
                new Function0<Integer>() {
                    public Integer apply() throws InterruptedException {
                        return slowDownRequest(delay);
                    }
                }
                );
        return promiseOfInt.map(
                new Function<Integer, Result>() {
                    public Result apply(Integer delayToUse) {
                        return ok(String.format("Result was delayed by %d milliseconds",
                                delayToUse));
                    }
                }
                );
    }

    /**
     * Slows down the request by {@code delay} milliseconds.
     * <p>
     * If {@code null}, use a random delay.
     * </p>
     * @throws InterruptedException
     */
    private static Integer slowDownRequest(Integer delay) throws InterruptedException {
        if (delay == null) {
            // pick a random delay
            delay = pickRandomDelay();
        }

        Thread.sleep(delay);

        return delay;
    }

    /**
     * Pick a random delay between 0 and 10,000
     */
    private static int pickRandomDelay() {
        Random random = new Random();

        return random.nextInt(10001);
    }
}
