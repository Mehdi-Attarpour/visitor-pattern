package io.learning.visitor.domain;

import io.learning.visitor.visitor.EmployeeVisitor;

public interface Employee {
    <T> T visit(final EmployeeVisitor<T> visitor);
}
