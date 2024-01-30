#!/bin/sh

set -ue

RepositoryName="ola-devops-me"
AwsRegion="sa-east-1"
CodeCommitUrl="https://git-codecommit.sa-east-1.amazonaws.com/v1/repos/ola-devops-me"

git config --global --add safe.directory /github/workspace
git config --global credential.'https://git-codecommit.*.amazonaws.com'.helper '!aws codecommit credential-helper $@'
git config --global credential.UseHttpPath true
git remote add sync ${CodeCommitUrl}
git push sync --mirror