package Project;

import com.sun.istack.internal.NotNull;

public class Project {
    @NotNull
    private ProjectType projectType;

    @NotNull
    private String projectName;

    public Project(ProjectType projectType, String projectName){
        this.projectType = projectType;
        this.projectName = projectName;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public String getProjectName() {
        return projectName;
    }
}
