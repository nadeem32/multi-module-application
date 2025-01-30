@echo off
REM Define variables
set REPO_DIR=D:\FinalProject\multi-module-application\multi-module-application
set COMMIT_MESSAGE=Automated commit message

REM Navigate to the repository directory
cd /d %REPO_DIR% || (
    echo Failed to navigate to the repository. Please check the REPO_DIR path.
    pause
    exit /b 1
)

REM Check if the directory is a Git repository
if not exist ".git" (
    echo ERROR: This is not a Git repository. Please check the REPO_DIR path.
    pause
    exit /b 1
)

REM Pull changes from the remote repository to avoid conflicts
echo Pulling latest changes...
git pull origin main || (
    echo ERROR: Git pull failed. Please check your connection.
    pause
    exit /b 1
)

REM Add all changes to the staging area
echo Adding changes...
git add . || (
    echo ERROR: Git add failed.
    pause
    exit /b 1
)

REM Commit changes with a message
echo Committing changes...
git commit -m "%COMMIT_MESSAGE%" || (
    echo ERROR: Git commit failed. No changes to commit?
    pause
    exit /b 1
)

REM Push changes to the remote repository
echo Pushing to repository...
git push origin main || (
    echo ERROR: Git push failed. Please check your remote and authentication.
    pause
    exit /b 1
)

REM Success message
echo ✅ Changes have been pushed successfully!
pause
