package com.example.ftp;

import java.util.Collections;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.ChannelSftp.LsEntrySelector;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class DeleteFileFromSFTPServer {
    
    private static Session session = null;
    private static Channel channel = null;
    private static ChannelSftp channelSftp = null;
    
    public static void main(String[] args) {
        
        String SFTPHOST = "transfer.ftpvault.io"; // SFTP Host Name or SFTP Host IP Address
        int SFTPPORT = 2222; // SFTP Port Number
        String SFTPUSER = "5ef058"; // User Name
        String SFTPPASS = "ba0f328"; // Password
        String SFTPWORKINGDIR = "/Products"; // Source Directory on SFTP server in which the file is located on remote server
        boolean deletedflag = false;

        try {
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(); // Create SFTP Session
            channel = session.openChannel("sftp"); // Open SFTP Channel
            channel.connect();
            channelSftp = (ChannelSftp) channel;
            channelSftp.cd(SFTPWORKINGDIR); // Change Directory on SFTP Server
           
            channelSftp.cd(SFTPWORKINGDIR);
            Vector<String> filelist=new Vector<String>();
            LsEntrySelector selector = new LsEntrySelector() {
                public int select(LsEntry entry)  {
                    final String filename = entry.getFilename();
                    if (filename.equals(".") || filename.equals("..")) {
                        return CONTINUE;
                    }
                    if (entry.getAttrs().isLink()) {
                        filelist.addElement(filename);
                    }
                    else if (entry.getAttrs().isDir()) {
                        //if (keepDirectory(filename)) {
                        filelist.addElement(entry.getFilename());
                        //}
                    }
                    else {
                        //if (keepFile(filename)) {
                        filelist.addElement(entry.getFilename());
                        //}
                    }
                    return CONTINUE;
                }
            };
            channelSftp.ls(SFTPWORKINGDIR,selector);
         
            
            
            
            if(filelist.size()<8)
            {
            	System.out.println("All Good No file deleted");
            }
            else {
            	Collections.sort(filelist,Collections.reverseOrder());
            	
            		for (int i = 6; i < filelist.size(); i++)
            		{
            			System.out.println(filelist.get(i));
            			channelSftp.rm(filelist.get(i).toString()); // This method removes the file from remote server
			            deletedflag = true;
			            if(deletedflag)
			                System.out.println("File deleted successfully.");
            
                    }
            	}
            }
            catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if (channelSftp != null)
                channelSftp.disconnect();
            if (channel != null)
                channel.disconnect();
            if (session != null)
                session.disconnect();

        }

    }

}