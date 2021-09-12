package io.learning.visitor.visitor;

import io.learning.visitor.domain.Clerk;
import io.learning.visitor.domain.Developer;
import io.learning.visitor.domain.Employee;
import io.learning.visitor.domain.Manager;
import io.learning.visitor.visitor.impl.BonusVisitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusVisitorTest {

    public static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(new Manager(100), 20.0),
                Arguments.of(new Developer(100), 30.0),
                Arguments.of(new Clerk(100), 10.0)
        );
    }

    @DisplayName("Bonus-visitor-for:")
    @ParameterizedTest
    @MethodSource("getParams")
    void bonusVisitorTest(final Employee employee, final Double expectedBonus) {

        final EmployeeVisitor<Double> bonusVisitor = new BonusVisitor();
        final Double bonus = employee.visit(bonusVisitor);

        assertEquals(expectedBonus, bonus);
    }
}