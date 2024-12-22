package com.example.saas.devsecurity;

import com.example.saas.devsecurity.domain.GitCommit;
import com.example.saas.devsecurity.domain.Vulnerability;
import com.example.saas.devsecurity.service.GitRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GitBlameHelper {
    @Autowired
    private GitRepositoryService gitRepositoryService;

    public void blameFiles(String repoPath, List<Vulnerability> vulnerabilities) throws Exception {
        for (Vulnerability v : vulnerabilities) {
            GitCommit commit = gitRepositoryService.blameFile(repoPath, v.getFilePath(), v.getLineNumber());
            v.setIntroducedByCommit(commit.getCommitId());
        }
    }
}
