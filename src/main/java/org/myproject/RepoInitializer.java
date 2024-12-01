package org.myproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class RepoInitializer {

    public static void initGitRepo(){
        File gitDir = new File(".git");
        if (!gitDir.exists()) {
            if (!gitDir.mkdir()) {
                System.err.println("Failed to create .git directory.");
            }else {
                System.out.println(".git directory created.");
            }

        }

        File objectsDir = new File(gitDir,"objects");
        if (!objectsDir.exists()) {
            if (!objectsDir.mkdir()) {
                System.err.println("Failed to create .git/objects directory.");
            }else {
                System.out.println("Created .git/objects directory.");
            }
        }

        File refsDir = new File(gitDir,"refs");
        if (!refsDir.exists()) {
            if (!refsDir.mkdir()) {
                System.err.println("Failed to create .git/refs directory.");
            }else {
                System.out.println("Created .git/refs directory.");
            }
        }


        File headFile = new File(gitDir,"Head");
        if (!headFile.exists()) {
            try {
                Files.write(headFile.toPath(), "ref: refs/heads/main\n".getBytes());
                System.out.println("Created .git/HEAD file pointing to refs/heads/main.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
