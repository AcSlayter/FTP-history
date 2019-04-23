package com.exc;

import com.exc.ftp.FTPServer;
import com.exc.util.CmdHelper;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        String userName =  CmdHelper.getArg(args,"userName");
        String password = CmdHelper.getArg(args,"password");
        String host = CmdHelper.getArg(args,"host");

        FTPServer ftpServer = new FTPServer(userName, password, host);
        try {
            ftpServer.connect();
            ftpServer.getFileStructure();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ftpServer.close();
        }


    }
}
