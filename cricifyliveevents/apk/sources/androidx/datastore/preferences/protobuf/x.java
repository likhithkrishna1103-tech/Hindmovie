package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f809b;

    static {
        Charset.forName("US-ASCII");
        f808a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f809b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new h(bArr, 0, 0, false).e(0);
        } catch (z e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }
}
