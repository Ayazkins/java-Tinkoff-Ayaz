package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    @Test
    @DisplayName("Catch Connection Exception test")
    void ExceptionTest() throws Exception {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 2);
        try {
            executor.updatePackages();
        }
        catch (Throwable e) {
            assertThat(e.getMessage()).isEqualTo("Failed");
        }
    }
}
