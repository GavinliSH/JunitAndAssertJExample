import Expense.ExpenseType;
import Project.*;
import Exception.*;

import static Expense.ExpenseType.*;
import static Project.ProjectType.*;

class ExpenseService {
    static ExpenseType getExpenseCodeByProjectTypeAndName(Project project) throws UnexpectedProjectTypeException {
        if(project.getProjectType() == INTERNAL){
            return INTERNAL_PROJECT_EXPENSE;
        }else{
            if(project.getProjectType() == EXTERNAL){
                if(project.getProjectName().equals("Project A")){
                    return EXPENSE_TYPE_A;
                }

                if(project.getProjectName().equals("Project B")){
                    return EXPENSE_TYPE_B;
                }

                return OTHER_EXPENSE;
            }

            throw new UnexpectedProjectTypeException("You enter invalid project type");
        }
    }
}
