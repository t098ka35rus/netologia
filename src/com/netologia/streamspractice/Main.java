package com.netologia.streamspractice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        String path = "/Users/timofejzabolotko/Games/";
    makeNewDir(path, "src");
    makeNewDir(path, "res");
    makeNewDir(path, "savegames");
    makeNewDir(path, "temp");
    path = "/Users/timofejzabolotko/Games/src/";
    makeNewDir(path, "main");
    makeNewDir(path, "test");
    path = "/Users/timofejzabolotko/Games/res/";
    makeNewDir(path, "drawables");
    makeNewDir(path, "vectors");
    makeNewDir(path, "icons");
    path = "/Users/timofejzabolotko/Games/src/main/";
    makeNewFile(path,"Main.java");
    makeNewFile(path,"Utils.java");
    path = "/Users/timofejzabolotko/Games/temp/";
    makeNewFile(path,"temp.txt");
    logtotemp(sb);
        System.out.println("Печатаю стрингбилдер");
        System.out.println(sb.toString());

        GameProgress game1 = new GameProgress(1,2,4,12.12);
        GameProgress game2 = new GameProgress(3,7,2,233.12);
        GameProgress game3 = new GameProgress(4,23,45,1234.23);

        saveGame("/Users/timofejzabolotko/Games/savegames/game1.dat",game1);
        saveGame("/Users/timofejzabolotko/Games/savegames/game2.dat",game2);
        saveGame("/Users/timofejzabolotko/Games/savegames/game3.dat",game3);

        List<String> stringList = new ArrayList<>();
        stringList.add("/Users/timofejzabolotko/Games/savegames/game1.dat");
        stringList.add("/Users/timofejzabolotko/Games/savegames/game2.dat");
        stringList.add("/Users/timofejzabolotko/Games/savegames/game3.dat");

        zipFiles("/Users/timofejzabolotko/Games/savegames/gamesaved.zip",stringList);

    }

public static  void makeNewDir (String path, String name){
    File dir = new File (path + "/" + name);
    if (dir.mkdir())
      sb.append( path + name  + " :каталог создан" + "\n");
}
public static void makeNewFile (String path, String name){
    File myFile = new File(path + "//" + name);
    try {
        if (myFile.createNewFile())
            sb.append( path + name   + " :файл создан" + "\n");
            }
    catch (IOException ex) {
        System.out.println(ex.getMessage()); }
}
public static void logtotemp (StringBuilder sb){
    try (FileWriter writer = new FileWriter("/Users/timofejzabolotko/Games/temp/temp.txt", false))
    {
        writer.write(sb.toString());
    } catch (IOException ex) { System.out.println(ex.getMessage());
    }
}

public static void saveGame(String path, GameProgress gameProgress){
    try (FileOutputStream fos = new FileOutputStream(path);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        oos.writeObject(gameProgress);
    }
    catch (Exception ex) {
        System.out.println(ex.getMessage()); }
}
public static void zipFiles(String zpath, List<String> path){
    try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zpath))) {
        for (int i = 0; i < path.size(); i++) {
            FileInputStream fis = new FileInputStream(path.get(i));
            ZipEntry entry = new ZipEntry("packed_" + path.get(i));
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()]; fis.read(buffer);
          File datfile = new File(path.get(i));
          datfile.delete();
        }
        zout.closeEntry();
    } catch (Exception ex) {
        System.out.println(ex.getMessage()); }

}
}
