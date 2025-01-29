@echo off
:: Batch script to automate Git pull, add, commit, and push commands

:: Define repository branch
set BRANCH=main

:: Pull the latest changes from the remote branch
echo Pulling the latest changes from the remote repository...
git pull origin %BRANCH% --rebase
if %ERRORLEVEL% neq 0 (
    echo.
    echo Failed to pull changes. Resolve conflicts manually if needed.
    pause
    exit /b
)

:: Stage all changes
echo Staging all changes...
git add -A
if %ERRORLEVEL% neq 0 (
    echo.
    echo Failed to stage changes. Please check your repository.
    pause
    exit /b
)

:: Commit changes
echo Enter commit message:
set /p COMMIT_MESSAGE=
git commit -m "%COMMIT_MESSAGE%"
if %ERRORLEVEL% neq 0 (
    echo.
    echo No changes to commit or commit failed.
    pause
    exit /b
)

:: Push changes to the remote repository
echo Pushing changes to remote branch %BRANCH%...
git push -u origin %BRANCH%
if %ERRORLEVEL% neq 0 (
    echo.
    echo Push failed. Check for errors and resolve manually.
    pause
    exit /b
)

:: Success
echo.
echo Code pushed successfully to branch %BRANCH%.
pause
exit /b
