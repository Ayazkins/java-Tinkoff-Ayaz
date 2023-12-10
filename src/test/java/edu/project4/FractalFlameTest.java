package edu.project4;

import edu.project4.Transformations.FinalTransformation;
import edu.project4.Transformations.HeartTransformation;
import edu.project4.Transformations.SphericalTransformation;
import edu.project4.Transformations.SpiralTransformation;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutionException;

public class FractalFlameTest {
    @Test
    public void timeTest() throws InterruptedException, ExecutionException {
        FractalFlame fractalFlame = new FractalFlame();
        System.out.println("Однопоточная версия");
        long start = System.currentTimeMillis();
        var a = fractalFlame.oneThreadGeneration(1920, 1080, 30000, 1000, 10, 1, new FinalTransformation[]{  new SpiralTransformation()});
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("Многопоточная версия");
        start = System.currentTimeMillis();
        fractalFlame.multiThreadGeneration(1920, 1080, 30000, 1000, 10, 1, new FinalTransformation[]{  new SpiralTransformation()}, 4);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
