package com.example.saas.devsecurity.service;

import com.example.saas.devsecurity.domain.Container;
import org.springframework.stereotype.Service;

@Service
public class ContainerServiceImpl implements ContainerService {

    @Override
    public Container getContainerDetails(String containerId) {
        // Dummy implementation
        return new Container(containerId, "my-ecr-repo:latest", "my-ecr-repo", "Running");
    }
}
