package io.learning.visitor.visitor;

import io.learning.visitor.domain.Clerk;
import io.learning.visitor.domain.Developer;
import io.learning.visitor.domain.Employee;
import io.learning.visitor.domain.Manager;
import io.learning.visitor.visitor.impl.TaxVisitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxVisitorTest {

    public static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(new Manager(100), 30.0),
                Arguments.of(new Developer(100), 20.0),
                Arguments.of(new Clerk(100), 10.0)
        );
    }

    @DisplayName("Tax-visitor-for:")
    @ParameterizedTest
    @MethodSource("getParams")
    void taxVisitorTest(final Employee employee, final Double expectedTax) {
        final EmployeeVisitor<Double> taxVisitor = new TaxVisitor();
        final Double tax = employee.visit(taxVisitor);
        assertEquals(expectedTax, tax);

    }
}
