package collection.compare;

public final class _0212_01_CaseInsensitiveString implements Comparable<_0212_01_CaseInsensitiveString> {

    private String s;

    @Override
    public int compareTo(_0212_01_CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }

}
