package o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f9030e = new byte[1792];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f9031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f9034d;

    static {
        for (int i = 0; i < 1792; i++) {
            f9030e[i] = Character.getDirectionality(i);
        }
    }

    public a(CharSequence charSequence) {
        this.f9031a = charSequence;
        this.f9032b = charSequence.length();
    }

    public final byte a() {
        int i = this.f9033c - 1;
        CharSequence charSequence = this.f9031a;
        char cCharAt = charSequence.charAt(i);
        this.f9034d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f9033c);
            this.f9033c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f9033c--;
        char c9 = this.f9034d;
        return c9 < 1792 ? f9030e[c9] : Character.getDirectionality(c9);
    }
}
