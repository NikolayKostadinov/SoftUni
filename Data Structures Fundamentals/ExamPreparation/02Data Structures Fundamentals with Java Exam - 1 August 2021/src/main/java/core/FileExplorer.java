package core;

import model.File;
import model.SampleFile;
import shared.FileManager;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FileExplorer implements FileManager {
    private File root;
    private static ArrayDeque<File> buffer = new ArrayDeque<>();

    public FileExplorer() {
        this.root = new SampleFile(1, "Root");
    }

    @Override
    public void addInDirectory(int directorNumber, File file) {
        File dir = findDirectory(root, directorNumber);
        ensureDir(dir);
        dir.getChildren().add(file);
    }

    private void ensureDir(File dir) {
        if (dir == null) throw new IllegalStateException();
    }

    private File findDirectory(File file, int directorNumber) {
        Deque<File> queue = new ArrayDeque<>();
        queue.offer(file);
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            if (currentFile.getNumber() == directorNumber) {
                return currentFile;
            }
            currentFile.getChildren()
                    .forEach(ch -> queue.offer(ch));
        }

        return null;
    }

    @Override
    public File getRoot() {
        return this.root;
    }

    @Override
    public File get(int number) {
        File dir = findDirectory(root, number);
        ensureDir(dir);
        return dir;
    }

    @Override
    public Boolean deleteFile(File file) {
        Deque<PrevCurrent> queue = new ArrayDeque<>();
        queue.offer(new PrevCurrent(null, root));
        while (!queue.isEmpty()) {
            PrevCurrent current = queue.poll();
            if (current.current.getNumber() == file.getNumber()) {
                if (current.prev != null) {
                    current.prev.getChildren().remove(file);
                } else {
                    this.root = null;
                }

                return true;
            }
            current.current.getChildren()
                    .forEach(ch -> queue.offer(new PrevCurrent(current.current, ch)));
        }

        return false;
    }


    @Override
    public List<File> getFilesInPath(File path) {
        File directory = get(path.getNumber());
        return directory.getChildren();
    }

    @Override
    public void move(File file, File destination) {
        File src = get(file.getNumber());
        if (src.getNumber()==root.getNumber()) throw new IllegalStateException();
        deleteFile(src);
        if (src != null) {
            File dest = get(destination.getNumber());
            dest.getChildren().add(src);
        }
    }

    @Override
    public Boolean contains(File file) {
        return this.findDirectory(root, file.getNumber()) != null;
    }

    @Override
    public List<File> getInDepth() {
        List<File> order = new ArrayList<>();
        this.dfs(root, order);
        return order;
    }

    private void dfs(File file, List<File> order) {
        file.getChildren().forEach(ch -> dfs(ch, order));
        order.add(file);
    }


    @Override
    public List<File> getInLevel() {
        List<File> level = new ArrayList<>();
        bfs(root, level);
        return level;
    }

    private void bfs(File file, List<File> level) {
        Deque<File> queue = new ArrayDeque<>();
        queue.offer(file);
        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            level.add(currentFile);
            currentFile.getChildren()
                    .forEach(ch -> queue.offer(ch));
        }
    }

    @Override
    public void cut(int number) {
        File file = get(number);
        this.buffer.push(file);
        deleteFile(file);
    }

    @Override
    public void paste(File destination) {
        File dest = get(destination.getNumber());
        dest.getChildren().add(buffer.pop());
    }

    @Override
    public Boolean isEmpty() {
        return this.root.getChildren().isEmpty();
    }

    @Override
    public String getAsString() {
        if (this.root == null) {
            return "";
        }
        StringBuilder buffer = new StringBuilder();
        print(this.root, buffer, "", "");
        return buffer.toString().trim();
    }

    private void print(File file, StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(file.getNumber());
        buffer.append(System.lineSeparator());
        List<File> children = file.getChildren();
        for (int i = 0; i < children.size(); i++) {
            File next = children.get(i);
            if (i < children.size() - 1) {
                print(next, buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                print(next, buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    class PrevCurrent {
        File prev;
        File current;

        public PrevCurrent(File prev, File current) {
            this.prev = prev;
            this.current = current;
        }
    }
}
