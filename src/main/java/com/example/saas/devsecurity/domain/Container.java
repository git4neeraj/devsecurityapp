package com.example.saas.devsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Container {
    private String id;
    private String imageTag;
    private String ecrRepository;
    private String status;
}
