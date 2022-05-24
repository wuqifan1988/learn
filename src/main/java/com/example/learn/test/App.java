package com.example.learn.test;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Commit;
import org.gitlab4j.api.models.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

    static List<String> branches = Arrays.asList("dev-k8s", "test-k8s", "master");

    public static void tongji(String branch) throws GitLabApiException, ParseException {
        Set<String> username = new HashSet<>();
        Map<String, User> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //TODO 这写上你的token
        String token = "z9cxTQGU-dg5QjvfE7jx";
        GitLabApi gitLabApi = new GitLabApi("https://gitlab.indata.cc", token);
        //起止时间
        Date start = sdf.parse("2022-01-01 00:00:00");
        Date end = sdf.parse("2022-01-31 23:59:59");
        List<Project> projects = gitLabApi.getProjectApi().getProjects();
        for (Project project : projects) {

            Integer number = project.getId();
            try {
                List<Commit> commits = gitLabApi.getCommitsApi().getCommits(number, branch, start, end);

                for (Commit commit : commits) {
                    User user;
                    if (!username.contains(commit.getAuthorName())) {
                        user = new User();
                        user.setName(commit.getAuthorName());
                        user.setLine(0);
                        user.setCommitTimes(0);
                        map.put(commit.getAuthorName(), user);
                        username.add(commit.getAuthorName());
                    } else {
                        user = map.get(commit.getAuthorName());
                    }
//                System.out.print(commit.getAuthorName()+ "" + sdf.format(commit.getCommittedDate()));
                    commit = gitLabApi.getCommitsApi().getCommit(number, commit.getShortId());
                    user.setLine(user.getLine() + commit.getStats().getTotal());
                    user.setCommitTimes(user.getCommitTimes() + 1);
//                System.out.println("变更行数:"+commit.getStats().getTotal()+",累计变更行数："+user.getLine()+",累计提交次数："+user.getCommitTimes());
                }
            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("无权限");
            }

        }

        System.out.println("统计分支: " + branch);
        map.forEach(
                (key, value) -> System.out.printf("%s: 提交行数 %s%n", value.getName(), value.getLine())
        );

        System.out.println();


    }


    public static void main(String[] args) throws InterruptedException, ParseException, GitLabApiException {
        for(String branch: branches){
            tongji(branch);
        }

    }


}

class User {
    private String name;
    private int line;
    private int commitTimes;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", line=" + line +
                ", commitTimes=" + commitTimes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCommitTimes() {
        return commitTimes;
    }

    public void setCommitTimes(int commitTimes) {
        this.commitTimes = commitTimes;
    }
}