package org.example;

import org.example.ProjectDaoImpl;

public class ProjectDaoFactory {

    private static ProjectDao projectDao;

    private ProjectDaoFactory(){

    }

    public static ProjectDao getProjectDao(){
        if(projectDao == null){
            projectDao = new ProjectDaoImpl();
        }
        return projectDao;
    }

}