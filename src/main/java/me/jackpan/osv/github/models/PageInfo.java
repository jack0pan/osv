package me.jackpan.osv.github.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PageInfo {
    private String endCursor;
    private Boolean hasNextPage;
    private Boolean hasPreviousPage;
    private String startCursor;
}
