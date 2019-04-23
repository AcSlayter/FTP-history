package com.exc.ftp;

import com.exc.filesystem.DirectoryType;
import com.exc.filesystem.FileType;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class FTPServer {
    private String userName;
    private String password;
    private String host;

    private FTPClient ftpClient;
    private DirectoryType directoryType;

    public FTPServer(String userName, String password, String host) {
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.ftpClient = new FTPClient();
    }

    public void connect() throws IOException {
        ftpClient.connect(this.host);
        ftpClient.login(this.userName,this.password);

    }

    public DirectoryType getFileStructure() {

        if(ftpClient.isConnected()){
            this.directoryType = new DirectoryType("root", null, 0L, null);
            fileStructureHelp( this.directoryType, null);
        }

        return directoryType;
    }

    private void fileStructureHelp(DirectoryType directoryType, String path) {
        try {
            FTPFile[] ftpFiles;
            if (path == null) {
                ftpFiles = ftpClient.listFiles();
                path = "";
            } else {
                System.out.println("Getting Files for path :" + path);
                ftpFiles = ftpClient.listFiles(path);
            }

            for (FTPFile files : ftpFiles) {
                if (files.isDirectory() || files.isSymbolicLink() ) {
                    DirectoryType childDir = new DirectoryType(files.getName(), files.getTimestamp(), files.getSize(), directoryType);
                    fileStructureHelp(childDir, path.concat("/").concat(files.getName()));
                    directoryType.setChildren(childDir);
                } else if (files.isFile()) {
                    directoryType.setChildren(new FileType(files.getName(), files.getTimestamp(), files.getSize(), directoryType));
                } else {
                    System.out.println("NOT VALID");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFile() throws IOException {
        if(ftpClient.isConnected()){
            ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

        }
    }

}
