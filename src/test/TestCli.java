/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cli.reader.CliPointReader;
import point.interfaces.IPoint;

/**
 *
 * @author KevinJio
 */
public class TestCli {
    public static void main(String[] args){
        CliPointReader clireader = new CliPointReader(1);
        IPoint p = clireader.read(null);
        System.out.println(p);
    }
}
