package io.learning.visitor.visitor;

import io.learning.visitor.domain.Clerk;
import io.learning.visitor.domain.Developer;
import io.learning.visitor.domain.Employee;
import io.learning.visitor.domain.Manager;
import io.learning.visitor.visitor.impl.SpeechVisitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeechVisitorTest {

    private final static String MANAGER_SPEECH = "Our company is the best!!!";
    private final static String DEVELOPER_SPEECH = "No comments!!!";
    private final static String CLERK_SPEECH = "Too much paper work!!!";


    public static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(new Manager(100), MANAGER_SPEECH),
                Arguments.of(new Developer(100), DEVELOPER_SPEECH),
                Arguments.of(new Clerk(100), CLERK_SPEECH)
        );
    }

    @DisplayName("Speech-visitor-for:")
    @ParameterizedTest
    @MethodSource("getParams")
    void speechVisitorTest(final Employee employee, final String expectedSpeech) {

        final EmployeeVisitor<String> speechVisitor = new SpeechVisitor();
        final String speech = employee.visit(speechVisitor);

        assertEquals(expectedSpeech, speech);
    }
}
