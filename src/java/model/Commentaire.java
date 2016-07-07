/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "commentaire", schema = "public")

public class Commentaire implements java.io.Serializable {
    private int idCommentaire;
    private String commentaire;
    private Date date;
    private int vote;

    public Commentaire() 
    {
        
    }

    public Commentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }
    

    public Commentaire(String commentaire, Date date, int vote) {
        this.commentaire = commentaire;
        this.date = date;
        this.vote = vote;
    }
    @Id
    @Column(name = "idCommentaire", unique = true, nullable = false)
    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    @Column(name = "commentaire", length = 10000)
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Temporal(TemporalType.DATE)
@Column(name = "date")
public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   
@Column(name = "vote")
    public int getVote() {
        return vote;
    }

    

    public void setVote(int vote) {
        this.vote = vote;
    }
    
    
}
