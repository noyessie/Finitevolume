/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.file;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import test.file.interfaces.IFile;

/**
 *
 * @author USER
 */
public class AbstractFile implements IFile{
    List<String> lines;
    String content = "";
    
    public AbstractFile(String fileName) throws FileNotFoundException, IOException{
        this.lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        for(String s : lines){
            content += s;
        }
        
        System.out.println("contruction du fichier complet");
    }

    @Override
    public String getLigne(int ligne) {
        return lines.get(ligne);
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public int getNumberOfLine() {
        return lines.size();
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
    
}
