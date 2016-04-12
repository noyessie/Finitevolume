/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.formater;

import test.file.AbstractFile;
import test.file.interfaces.IFile;

/**
 *
 * @author USER
 */
public class TestFormaterFile {
    TestFormater[] testFormaters;
    
    public TestFormaterFile(String fileName) throws Exception{
        IFile f = new AbstractFile(fileName);
        System.out.println(f.getLigne(0));
        testFormaters = new TestFormater[f.getNumberOfLine()];
        
        for(int i=0 ; i<f.getNumberOfLine() ; i++){
            testFormaters[i] = new TestFormater(f.getLigne(i), 1);
        }
    }

    public TestFormater[] getTestFormaters() {
        return testFormaters;
    }

    public void setTestFormaters(TestFormater[] testFormaters) {
        this.testFormaters = testFormaters;
    }

    @Override
    public String toString() {
        return "TestFormaterFile{" + "testFormaters=" + testFormaters + '}';
    }
    
    
    
}
