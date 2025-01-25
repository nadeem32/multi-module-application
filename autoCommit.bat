@echo off
REM Define variables
set REPO_DIR=D:\FinalProject\GitHubProject\multi-module-application
set COMMIT_MESSAGE="Automated commit message"

REM Navigate to the repository directory
cd /d %REPO_DIR%

REM Check if the directory is a Git repository
if not exist ".git" (
    echo This is not a Git repository. Please check the REPO_DIR path.
    pause
    exit /b 1
)

REM Add all changes to the staging area
git add .

REM Commit changes with a message
git commit -m %COMMIT_MESSAGE%

REM Push changes to the remote repository
git push origin main

REM Optional: Provide feedback
echo Changes have been pushed to the repository.
pause
