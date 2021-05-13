package amit.problems.strings;

import java.util.Stack;

/**
 *
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level,
 * and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 *     The path starts with a single slash '/'.
 *     Any two directories are separated by a single slash '/'.
 *     The path does not end with a trailing '/'.
 *     The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 *
 * Return the simplified canonical path.
 *
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {

    //Status Works
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String currDir = "";
        char prev = '/';
        for(char c: path.toCharArray()) {
            if(c == '/') {
                if(prev != '/') {
                    switch(currDir) {
                        case ".": break;
                        case "..":
                            if(!stack.isEmpty()) {
                                stack.pop();
                            }
                            break;
                        default: stack.push(currDir);
                    }
                    currDir = "";
                }
            } else {
                currDir += c;
            }

            prev = c;
        }
        if(prev != '/') {
            switch(currDir) {
                case ".": break;
                case "..":
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default: stack.push(currDir);
            }
        }
        if(stack.isEmpty()) {
            stack.push("");
        }
        StringBuilder absPath = new StringBuilder();
        while(!stack.isEmpty() && stack.peek() != null) {
            String dir = stack.pop();
            absPath.insert(0, dir);
            absPath.insert(0, "/");
        }
        return absPath.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/a//b////c/d//././/.."));// /a/b/c
        System.out.println(sp.simplifyPath("/a/./b/../../c/"));
        System.out.println(sp.simplifyPath("/../"));
        System.out.println(sp.simplifyPath("/home//foo/"));
    }
}
