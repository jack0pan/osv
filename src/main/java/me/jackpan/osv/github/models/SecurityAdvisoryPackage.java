package me.jackpan.osv.github.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class SecurityAdvisoryPackage {
    private String name;
    private String ecosystem;
}
