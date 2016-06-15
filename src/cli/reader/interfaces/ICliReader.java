/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cli.reader.interfaces;

import java.util.Map;

/**
 *
 * @author KevinJio
 */
public interface ICliReader<T> {
    public T read(Map params);
}
