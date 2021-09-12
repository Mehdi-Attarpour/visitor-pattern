package io.learning.visitor.visitor.impl;

import io.learning.visitor.domain.Clerk;
import io.learning.visitor.domain.Developer;
import io.learning.visitor.domain.Manager;
import io.learning.visitor.visitor.EmployeeVisitor;

public class TaxVisitor implements EmployeeVisitor<Double> {
    @Override
    public Double accept(final Manager manager) {
        return manager.getSalary() * 0.3;
    }

    @Override
    public Double accept(final Developer developer) {
        return developer.getSalary() * 0.2;
    }

    @Override
    public Double accept(final Clerk clerk) {
        return clerk.getSalary() * 0.1;
    }
}
