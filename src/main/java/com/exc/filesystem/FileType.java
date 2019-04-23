package com.exc.filesystem;

import java.util.Calendar;

public class FileType implements IFileSystem {
    private FILE_TYPE file_type;
    private String name;
    private DirectoryType parent;
    private Calendar timestamp;
    private long size;

    public FileType(String name, Calendar timestamp, long size, DirectoryType directoryType) {
        this.file_type = FILE_TYPE.FILE;
        this.name = name;
        this.parent = directoryType;
        this.timestamp = timestamp;
        this.size = size;
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



}
