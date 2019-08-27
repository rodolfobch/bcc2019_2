/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelasinternas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Laboratorio
 */
public class Cliente {

    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    private String endereco;

    public static final String PROP_ENDERECO = "endereco";

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        propertyChangeSupport.firePropertyChange(PROP_ENDERECO, oldEndereco, endereco);
    }
    
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
}
