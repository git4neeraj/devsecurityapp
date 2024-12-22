package com.example.saas.devsecurity.service;

import com.example.saas.devsecurity.domain.GitCommit;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;


public interface GitRepositoryService {
    GitCommit blameFile(String repoPath, String filePath, int lineNumber) throws GitAPIException, IOException;
}
