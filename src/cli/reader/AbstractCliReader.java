/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cli.reader;

import cli.reader.interfaces.ICliReader;
import java.util.Scanner;

/**
 *
 * @author KevinJio
 * @param <T>
 */
public abstract class AbstractCliReader<T> implements ICliReader<T>{
    protected Scanner sc = new Scanner(System.in);
}
