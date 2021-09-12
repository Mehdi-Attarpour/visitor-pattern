package io.learning.visitor;

import io.learning.visitor.domain.Developer;
import io.learning.visitor.domain.Employee;
import io.learning.visitor.visitor.EmployeeVisitor;
import io.learning.visitor.visitor.impl.BonusVisitor;
import io.learning.visitor.visitor.impl.SpeechVisitor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {

        final Employee developer = new Developer(70);

        final EmployeeVisitor<Double> bonusVisitor = new BonusVisitor();
        final EmployeeVisitor<String> speechVisitor = new SpeechVisitor();

        log.info("Speech from developer: {}", developer.visit(speechVisitor));
        log.info("Bonus calculated for developer: {}", developer.visit(bonusVisitor));

    }

}
