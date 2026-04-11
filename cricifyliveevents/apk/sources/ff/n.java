package ff;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f4604b;

    static {
        String[] strArr = new String[93];
        for (int i = 0; i < 32; i++) {
            strArr[i] = "\\u" + a(i >> 12) + a(i >> 8) + a(i >> 4) + a(i);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f4603a = strArr;
        byte[] bArr = new byte[93];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr[i10] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f4604b = bArr;
    }

    public static final char a(int i) {
        int i10 = i & 15;
        return (char) (i10 < 10 ? i10 + 48 : i10 + 87);
    }
}
