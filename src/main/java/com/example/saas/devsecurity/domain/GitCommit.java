package com.example.saas.devsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GitCommit {
    private String commitId;
    private String authorName;
    private String filePath;
    private int lineNumber;
    private String commitMessage;
    private String commitDate;
}
