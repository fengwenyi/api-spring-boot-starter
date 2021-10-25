#!/bin/zsh
mvn clean deploy -P release -DskipTests
git tag -a 1.1.0 -m 'v1.1.0'
git push origin 1.1.0