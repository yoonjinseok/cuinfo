package com.cyberup.controller.mgr.educ;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import com.cyberup.model.home.FileUpload;


// 폴드 생성 -> 폴드아래 파일생성-> 파일 내용 쓰기-> 
//		zip처리하기->파일 삭제-> 고개단 발송-> zip파일 삭제
public class ZipFileDownUtil {
	private String zipPath = "";
	private String copDirPath = "";
	
	// 파일 양식관리에서 대학별 통계파일 다운
	public void getUnivZipFile(List fileList, String path, String copyPolderName, String zipName) throws Exception 
	{
		
		System.out.println("zipName ==> " + zipName);
		
		zipPath = path + UUID.randomUUID().toString();
		copDirPath = zipPath + "/" + copyPolderName;
		
		System.out.println("zipPath ==> " + zipPath);
		
		File zipPathPolder = createDir(zipPath);
		createDir(copDirPath);

		BufferedInputStream src = null;
		BufferedOutputStream org = null;
		Iterator it = (Iterator) fileList.iterator();
		
		while(it.hasNext())
		{
			FileUpload bf = (FileUpload)it.next();
			src = new BufferedInputStream(new FileInputStream(bf.getUpfilePath())); // 인풋객체생성
			String fileStyle = bf.getUpfileFilename().substring(bf.getUpfileFilename().lastIndexOf("."));
			org = new BufferedOutputStream(new FileOutputStream(zipPath + "/" + copyPolderName + "/" + bf.getUnivName() +  fileStyle )); // 응답객체생성
			
			byte b[] = new byte[1024];
			int read = 0;
			
		    while ((read = src.read(b)) != -1) {
		    	org.write(b,0,read);
		    }
		    
		    org.close();
		    src.close();
		}
		
		// zip 파일 만들기
		 zip(zipPath + "/" + zipName, copDirPath);
	    // zip 폴더 삭제
	    //delDir(zipPathPolder);
	}
		
	// 대학별 통계관리에서 양식 파일다운
	public void getStyleZipFile(List fileList, String path, String copyPolderName, String zipName) throws Exception {
		zipPath = path + UUID.randomUUID().toString();
		copDirPath = zipPath + "/" + copyPolderName;
		
		File zipPathPolder = createDir(zipPath);
		createDir(copDirPath);

		BufferedInputStream src = null;
		BufferedOutputStream org = null;
		Iterator it = (Iterator) fileList.iterator();
		
		while(it.hasNext())
		{
			FileUpload bf = (FileUpload)it.next();
			src = new BufferedInputStream(new FileInputStream(bf.getUpfilePath())); // 인풋객체생성
			org = new BufferedOutputStream(new FileOutputStream(zipPath + "/" + copyPolderName + "/" + bf.getUpfileFilename())); // 응답객체생성
			
			byte b[] = new byte[1024];
			int read = 0;
			
		    while ((read = src.read(b)) != -1) {
		    	org.write(b,0,read);
		    }
		    
		    org.close();
		    src.close();
		}

		// zip 파일 만들기
		 zipName = zipName.replaceAll("\\s", "");
		 zip(zipPath + "/" + zipName, copDirPath);
	    // zip 폴더 삭제
	    //delDir(zipPathPolder);
	}
	
	
	
	
	//폴드 만들기
	private File createDir(String path) throws Exception {
		File dirFile = null;
		dirFile = new File(path);
		if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
			dirFile.mkdirs();
		}
		return dirFile;
	}

	//파일만들기
	private File createFile(String path) throws Exception  {
		File file = new File(path);
		file.createNewFile();
		return file;
	}

	//파일삭제
	public boolean delFile(String path) throws Exception {
		boolean result = false;
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			file.delete();
			result = true;
		}
		return result;
	}

	//파일 및 폴드 삭제
	private boolean delDir(File folder)  throws Exception  {
		boolean result = false;
		String childs[] = folder.list();
		if (childs == null || childs.length <= 0) {
			if (folder.delete()) {
				result = true;
			}
		} else {
			for (int i = 0; i < childs.length; i++) {
				String childName = childs[i];
				String childPath = folder.getPath() + File.separator
						+ childName;
				File filePath = new File(childPath);
				if (filePath.exists() && filePath.isFile()) {
					if (filePath.delete()) {
						result = true;
					} else {
						result = false;
						break;
					}
				} else if (filePath.exists() && filePath.isDirectory()) {
					if (delDir(filePath)) {
						result = true;
					} else {
						result = false;
						break;
					}
				}
			}
		}
		folder.delete();
		return result;
	}
	
	// zip 파일 및 폴드 삭제
	public boolean delZipDir(String zipPath)  throws Exception {
		File zipFolder = new File(zipPath);
		boolean result = false;
		String childs[] = zipFolder.list();
		if (childs == null || childs.length <= 0) {
			if (zipFolder.delete()) {
				result = true;
			}
		} else {
			for (int i = 0; i < childs.length; i++) {
				String childName = childs[i];
				String childPath = zipFolder.getPath() + File.separator
				+ childName;
				File filePath = new File(childPath);
				if (filePath.exists() && filePath.isFile()) {
					if (filePath.delete()) {
						result = true;
					} else {
						result = false;
						break;
					}
				} else if (filePath.exists() && filePath.isDirectory()) {
					if (delDir(filePath)) {
						result = true;
					} else {
						result = false;
						break;
					}
				}
			}
		}
		zipFolder.delete();
		return result;
	}
	
	// zip 파일 및 폴드 삭제
	public boolean delZipDir()  throws Exception {
		File zipFolder = new File(zipPath);
		boolean result = false;
		String childs[] = zipFolder.list();
		if (childs == null || childs.length <= 0) {
			if (zipFolder.delete()) {
				result = true;
			}
		} else {
			for (int i = 0; i < childs.length; i++) {
				String childName = childs[i];
				String childPath = zipFolder.getPath() + File.separator
				+ childName;
				File filePath = new File(childPath);
				if (filePath.exists() && filePath.isFile()) {
					if (filePath.delete()) {
						result = true;
					} else {
						result = false;
						break;
					}
				} else if (filePath.exists() && filePath.isDirectory()) {
					if (delDir(filePath)) {
						result = true;
					} else {
						result = false;
						break;
					}
				}
			}
		}
		zipFolder.delete();
		return result;
	}

	/**
	 * 
	 * @param zipFilePath
	 * 		zip 파일 저장 경로
	 * @param inputFolderName
	 * 		zip 처리할 파일 경로
	 * @throws Exception
	 */
	public void zip(String zipFilePath, String inputFolderName)
			throws Exception {
		String zipFileName = zipFilePath; // zip 처리후 파일명
		File zipFile = new File(inputFolderName);
		zip(zipFileName, zipFile);
	}

	private void zip(String zipFileName, File inputFolder) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(zipFileName);
		ZipOutputStream out = new ZipOutputStream(fileOut);
		out.setEncoding("utf-8");
		zip(out, inputFolder, "");
		out.close();
		fileOut.close();
	}

	private void zip(ZipOutputStream out, File inputFolder, String base)
			throws Exception {
		if (inputFolder.isDirectory()) {
			File[] fl = inputFolder.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(inputFolder);
			int b;
			// System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}

	public String getZipPath() {
		return zipPath;
	}
	public void setZipPath(String zipPath) {
		this.zipPath = zipPath;
	}
	public String getCopDirPath() {
		return copDirPath;
	}
	public void setCopDirPath(String copDirPath) {
		this.copDirPath = copDirPath;
	}
	
}
