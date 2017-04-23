package com.github.alebabai.jmp2k17.gradle.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;


public class GitHubIssuesPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.println("Plugin has been applied");
    }
}
