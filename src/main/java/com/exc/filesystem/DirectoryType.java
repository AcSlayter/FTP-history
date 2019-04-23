package com.exc.filesystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DirectoryType implements IFileSystem {
    private FILE_TYPE file_type;
    private String name;
    private DirectoryType parent;
    private List<IFileSystem> children;
    private Calendar timestamp;
    private long size;

    public DirectoryType(String name, Calendar timestamp, long size, DirectoryType directoryType) {
        this.file_type = FILE_TYPE.DIRECTORY;
        this.name = name;
        this.timestamp = timestamp;
        this.size = size;
        this.parent = directoryType;
        this.children = new ArrayList<IFileSystem>();

    }

    public Calendar getTimestamp() {
        return this.timestamp;
    }

    public long getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public boolean isFile() {
        if(file_type.equals(FILE_TYPE.FILE)) {
            return true;
        }
        return false;
    }

    public boolean isDir() {
        if(file_type.equals(FILE_TYPE.DIRECTORY)) {
            return true;
        }
        return false;
    }

    public void setChildren(IFileSystem children) {
        this.children.add(children);
    }


}
