package com.roothomes.common.util;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipCompress
{
    private String zipFileName;      // 目的地Zip文件
    private String sourceFileName;   //源文件（带压缩的文件或文件夹）
    
    public ZipCompress(String zipFileName,String sourceFileName)
    {
        this.zipFileName=zipFileName;
        this.sourceFileName=sourceFileName;
    }
    
    public void zip() throws Exception
    {
        //File zipFile = new File(zipFileName);
        System.out.println("压缩中...");
        
        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream( new FileOutputStream(zipFileName));
        
        //创建缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(out);
        
        File sourceFile = new File(sourceFileName);
        
        //调用函数
        compress(out,bos,sourceFile,sourceFile.getName());
        
        bos.close();
        out.close();
        System.out.println("压缩完成");
        
    }
    
    public void compress(ZipOutputStream out,BufferedOutputStream bos,File sourceFile,String base) throws Exception
    {
        //如果路径为目录（文件夹）
        if(sourceFile.isDirectory())
        {
        
            //取出文件夹中的文件（或子文件夹）
            File[] flist = sourceFile.listFiles();
            
            if(flist.length==0)//如果文件夹为空，则只需在目的地zip文件中写入一个目录进入点
            {
                System.out.println(base+"/");
                out.putNextEntry(  new ZipEntry(base+"/") );
            }
            else//如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
            {
                for(int i=0;i<flist.length;i++)
                {
                    compress(out,bos,flist[i],base+"/"+flist[i].getName());
                }
            }
        }
        else//如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
        {
            out.putNextEntry( new ZipEntry(base) );
            FileInputStream fos = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fos);
            
            int tag;
            System.out.println(base);
            //将源文件写入到zip文件中
//            while((tag=bis.read())!=-1)
//            {
//                bos.write(tag);
//            }
            int buffer = 2048;
            int count = 0;
            byte[] data = new byte[buffer];

            while ((count = bis.read(data,0,buffer))!= -1) {
                bos.write(data,0,count);
            }
            bos.flush();

            bis.close();
            fos.close();
            
        }
    }

    /**
     * 程序主入口
     * @param args
     * @throws FileNotFoundException
     */
    public static void mainxxx(String[] args){
        //输出流
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ZipOutputStream zipos = null;
        //输入流
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            //建立输出
            fos = new FileOutputStream("C:\\Documents and Settings\\Administrator\\桌面\\TestZip.zip");
            bos = new BufferedOutputStream(fos);
            zipos = new ZipOutputStream(bos);
            //条目列表以压缩方式（DEFLATED）方式加入ZIP文件中
            //zipos.setMethod(ZipOutputStream.DEFLATED);
            //条目列表以不压缩方式(STORED)方式加入ZIP文件中
            //zipos.setMethod(ZipOutputStream.DEFLATED);
            //建立与要压缩的文件列表的连接
            File fileDirectory = new File("C:\\Documents and Settings\\Administrator\\桌面\\zipFile");
            //获取文件列表
            String[] files = fileDirectory.list();
            ZipEntry entry = null;
            int buffer = 2048;
            int count = 0;
            byte[] data = new byte[buffer];
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i];
                System.out.println("添加文件：" + fileName);
                //建立输入
                fis = new FileInputStream(new File(fileDirectory,fileName));
                bis = new BufferedInputStream(fis);
                //读出的数据创建一个ZIP条目列表
                entry = new ZipEntry(fileName);
                //将ZIP条目列表写入输出流
                zipos.putNextEntry(entry);
                //将数据写入ZIP文件
                while ((count = bis.read(data,0,buffer))!= -1) {
                    zipos.write(data,0,count);
                }
                zipos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                zipos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void testmain(String[] args)
    {
        ZipCompress zipCom = new ZipCompress("D:\\svn\\trade\\App_cncsen\\Src\\fapplication-parent.zip","D:\\svn\\trade\\App_cncsen\\Src\\fapplication-parent");
        try
        {
            zipCom.zip();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}