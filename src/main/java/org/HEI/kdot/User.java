package org.HEI.kdot;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

// An user can have many users (Maybe not an user again, let's search another name for it)

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends Account {
    private List<SubscriptionRecord> subscriptionHistory;
    private List<Playlist> playlists;
    private List<WatchHistory> watchHistory;
    private List<String> searchHistory;
}