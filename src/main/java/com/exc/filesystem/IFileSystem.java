package com.exc.filesystem;

import java.util.Calendar;

public interface IFileSystem {

    Calendar getTimestamp();

    long getSize();

    String getName();

    boolean isFile();

    boolean isDir();
}
