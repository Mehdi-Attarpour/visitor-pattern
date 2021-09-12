package io.learning.visitor.visitor.impl;

import io.learning.visitor.domain.Clerk;
import io.learning.visitor.domain.Developer;
import io.learning.visitor.domain.Manager;
import io.learning.visitor.visitor.EmployeeVisitor;

public class SpeechVisitor implements EmployeeVisitor<String> {
    @Override
    public String accept(final Manager manager) {
        return "Our company is the best!!!";
    }

    @Override
    public String accept(final Developer developer) {
        return "No comments!!!";
    }

    @Override
    public String accept(final Clerk clerk) {
        return "Too much paper work!!!";
    }
}
