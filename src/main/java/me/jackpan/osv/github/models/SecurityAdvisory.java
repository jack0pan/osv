package me.jackpan.osv.github.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class SecurityAdvisory {
    private String ghsaId;
    private String summary;
}
