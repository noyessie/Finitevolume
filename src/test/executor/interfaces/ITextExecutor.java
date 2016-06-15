/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.executor.interfaces;

import test.formater.TestFormater;

/**
 *
 * @author ROY
 */
public interface ITextExecutor {
    public boolean execute(TestFormater tf) throws Exception;
    public String getLastError();
}
