package io.learning.visitor.domain;

import io.learning.visitor.visitor.EmployeeVisitor;
import lombok.Value;

@Value
public class Developer implements Employee {
    int salary;

    @Override
    public <T> T visit(final EmployeeVisitor<T> visitor) {
        return visitor.accept(this);
    }
}
