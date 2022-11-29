#### Java home works

## Create a SSH key pair

Skip this step if you have a pair of keys already

```shell
ssh-keygen -t ecdsa -b 521
```

## Install git

```shell
sudo apt install -y git
```

## Add the SSH key to GitHub account

[The official documentation by GitHub.](https://help.github.com/en/github/aut...)

## Create an empty repo on GitHub

*DO NOT create `README.md` and `.gitignore`.*
Copy the *SSH link* from this repo.

## Create the repo on the local machine

```shell
mkdir vscode_github && cd vscode_github
git init
git remote add origin {SSH link to GitHub Repo}
```