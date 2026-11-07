import java.util.Arrays;

public final class ArrayInfo {
    public static final int[] VALUES = {10, 20, 30, 40, 50, 60, 70, 80};

    private ArrayInfo() {
    }

    public static String asText() {
        return Arrays.toString(VALUES);
    }
}
