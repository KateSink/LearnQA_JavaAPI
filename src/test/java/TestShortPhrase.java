import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestShortPhrase {

    @ParameterizedTest
    @ValueSource(strings={"Короткая фраза", "Длинная предлинная фраза более 15 символов"})

    public void testLength (String phrase){
        assertTrue(phrase.length() >= 15, "Длина меньше 15");
    }
}
