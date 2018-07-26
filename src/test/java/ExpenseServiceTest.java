import Exception.UnexpectedProjectTypeException;
import Expense.ExpenseType;
import Project.Project;
import org.junit.jupiter.api.Test;

import static Expense.ExpenseType.*;
import static Project.ProjectType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_if_project_is_internal_project() throws UnexpectedProjectTypeException {
        Project internalProject = new Project(INTERNAL, "Kepler");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(internalProject);

        assertThat(expenseType).isEqualTo(INTERNAL_PROJECT_EXPENSE);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_project_and_name_is_project_A() throws UnexpectedProjectTypeException {
        Project internalProject = new Project(EXTERNAL, "Project A");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(internalProject);

        assertThat(expenseType).isEqualTo(EXPENSE_TYPE_A);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_project_and_name_is_project_B() throws UnexpectedProjectTypeException {
        Project internalProject = new Project(EXTERNAL, "Project B");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(internalProject);

        assertThat(expenseType).isEqualTo(EXPENSE_TYPE_B);
    }

    @Test
    void should_return_other_expense_if_project_is_external_project_and_name_is_other_project_name() throws UnexpectedProjectTypeException {
        Project internalProject = new Project(EXTERNAL, "Shenzhen");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(internalProject);

        assertThat(expenseType).isEqualTo(OTHER_EXPENSE);
    }

    @Test
    void should_throw_exception_for_unexpected_project_type(){
        Project errorProject = new Project(UNEXPECTED_PROJECT_TYPE, "error project");

        Throwable thrown = catchThrowable(
                () -> ExpenseService.getExpenseCodeByProjectTypeAndName(errorProject)
        );

        assertThat(thrown)
                .isInstanceOf(UnexpectedProjectTypeException.class)
                .hasMessage("You enter invalid project type");
    }
}
