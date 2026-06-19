package org.HEI.kdot;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends  Account{
    private Subcription abonnement;
    private List<Playlist> playlists;
}