package com.example.saas.devsecurity.service;

import com.example.saas.devsecurity.domain.GitCommit;
import lombok.extern.log4j.Log4j2;
import org.eclipse.jgit.api.BlameCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.blame.BlameResult;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
@Service
@Log4j2
public class GitRepositoryServiceImpl implements GitRepositoryService {

    @Override
    public GitCommit blameFile(String repoPath, String filePath, int lineNumber) throws GitAPIException, IOException {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        log.info("Blaming file: {} at line number: {}", filePath, lineNumber);
        Repository repository = builder.setGitDir(new File(repoPath + "/.git")).readEnvironment().findGitDir().build();

        try (Git git = new Git(repository)) {
            BlameCommand blameCommand = git.blame().setFilePath(filePath);
            BlameResult result = blameCommand.call();

            String commitId = result.getSourceCommit(lineNumber).getId().getName();
            String author = result.getSourceAuthor(lineNumber).getName();
            String commitMessage = result.getSourceCommit(lineNumber).getShortMessage();
            String commitDate = result.getSourceCommit(lineNumber).getCommitterIdent().getWhen().toString();

            return new GitCommit(commitId, author, filePath, lineNumber, commitMessage, commitDate);
        } catch (Exception e) {
            throw new RuntimeException("Error during git blame", e);
        }
    }
}
