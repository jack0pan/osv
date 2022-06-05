package me.jackpan.osv.github.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
public class Connection<T> {
    private List<T> nodes;
    private PageInfo pageInfo;
    private Integer totalCount;
}
