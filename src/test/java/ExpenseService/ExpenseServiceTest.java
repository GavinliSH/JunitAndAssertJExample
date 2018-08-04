package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        Project project = new Project(ProjectType.INTERNAL, "Internal Project");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);

        assertThat(expenseType).isEqualTo(ExpenseType.INTERNAL_PROJECT_EXPENSE);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        Project projectA = new Project(ProjectType.EXTERNAL, "Project A");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(projectA);

        assertThat(expenseType).isEqualTo(ExpenseType.EXPENSE_TYPE_A);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        Project projectB = new Project(ProjectType.EXTERNAL, "Project B");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(projectB);

        assertThat(expenseType).isEqualTo(ExpenseType.EXPENSE_TYPE_B);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        Project otherProject = new Project(ProjectType.EXTERNAL, "Other Project");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(otherProject);

        assertThat(expenseType).isEqualTo(ExpenseType.OTHER_EXPENSE);
    }
}