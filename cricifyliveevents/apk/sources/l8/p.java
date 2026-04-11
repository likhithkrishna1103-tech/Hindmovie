package l8;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f7904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f7906c;

    public /* synthetic */ p(boolean z10, String str, o oVar) {
        this.f7904a = z10;
        this.f7905b = str;
        this.f7906c = oVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MessageDigest messageDigest;
        boolean z10 = this.f7904a;
        String str = this.f7905b;
        o oVar = this.f7906c;
        String str2 = (z10 || !r.c(str, oVar, true, false).f7922a) ? "not allowed" : "debug cert rejected";
        int i = 0;
        while (true) {
            if (i >= 2) {
                messageDigest = null;
                break;
            }
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                break;
            }
            i++;
        }
        o8.u.g(messageDigest);
        byte[] bArrDigest = messageDigest.digest(oVar.f);
        int length = bArrDigest.length;
        char[] cArr = new char[length + length];
        int i10 = 0;
        for (byte b8 : bArrDigest) {
            char[] cArr2 = s8.b.f11612b;
            cArr[i10] = cArr2[(b8 & 255) >>> 4];
            cArr[i10 + 1] = cArr2[b8 & 15];
            i10 += 2;
        }
        return str2 + ": pkg=" + str + ", sha256=" + new String(cArr) + ", atk=" + z10 + ", ver=12451000.false";
    }
}
