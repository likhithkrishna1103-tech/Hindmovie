package r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f10828e = new byte[1792];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f10829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f10832d;

    static {
        for (int i = 0; i < 1792; i++) {
            f10828e[i] = Character.getDirectionality(i);
        }
    }

    public a(CharSequence charSequence) {
        this.f10829a = charSequence;
        this.f10830b = charSequence.length();
    }

    public final byte a() {
        int i = this.f10831c - 1;
        CharSequence charSequence = this.f10829a;
        char cCharAt = charSequence.charAt(i);
        this.f10832d = cCharAt;
        if (Character.isLowSurrogate(cCharAt)) {
            int iCodePointBefore = Character.codePointBefore(charSequence, this.f10831c);
            this.f10831c -= Character.charCount(iCodePointBefore);
            return Character.getDirectionality(iCodePointBefore);
        }
        this.f10831c--;
        char c9 = this.f10832d;
        return c9 < 1792 ? f10828e[c9] : Character.getDirectionality(c9);
    }
}
