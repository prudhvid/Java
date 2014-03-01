/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package snakeandladder;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Prudhvi
 */
@Entity
@Table(name = "GAMERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gamers.findAll", query = "SELECT g FROM Gamers g"),
    @NamedQuery(name = "Gamers.findByName", query = "SELECT g FROM Gamers g WHERE g.name = :name"),
    @NamedQuery(name = "Gamers.findByScore", query = "SELECT g FROM Gamers g WHERE g.score = :score")})
public class Gamers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "SCORE")
    private int score;

    public Gamers() {
    }

    public Gamers(String name) {
        this.name = name;
    }

    public Gamers(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gamers)) {
            return false;
        }
        Gamers other = (Gamers) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "snakeandladder.Gamers[ name=" + name + " ]";
    }
    
}
