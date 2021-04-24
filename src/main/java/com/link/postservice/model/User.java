package com.link.postservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="posts")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {


}
