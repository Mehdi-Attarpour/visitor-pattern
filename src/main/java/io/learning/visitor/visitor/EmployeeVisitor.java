package io.learning.visitor.visitor;

import io.learning.visitor.domain.Clerk;
import io.learning.visitor.domain.Developer;
import io.learning.visitor.domain.Manager;

public interface EmployeeVisitor<T> {
    T accept(final Manager manager);

    T accept(final Developer developer);

    T accept(final Clerk clerk);
}
