package edu.hw10.Task1.Objects;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;

public record GrownUpPersonRecord(@NotNull String name, @Min(18) @Max(199) int age) {
}
