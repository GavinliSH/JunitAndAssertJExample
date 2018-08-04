package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        Project project = new Project(ProjectType.INTERNAL, "Internal Project");
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);

        assertThat(expenseType).isEqualTo(ExpenseType.INTERNAL_PROJECT_EXPENSE);
    }
}