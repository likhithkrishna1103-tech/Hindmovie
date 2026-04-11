package q7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f11051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f11053c;

    public /* synthetic */ l(boolean z2, String str, o oVar) {
        this.f11051a = z2;
        this.f11052b = str;
        this.f11053c = oVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MessageDigest messageDigest;
        boolean z2 = this.f11051a;
        String str = this.f11052b;
        o oVar = this.f11053c;
        String str2 = (z2 || !q.b(str, oVar, true, false).f11069a) ? "not allowed" : "debug cert rejected";
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
        v.h(messageDigest);
        byte[] bArrDigest = messageDigest.digest(oVar.f);
        int length = bArrDigest.length;
        char[] cArr = new char[length + length];
        int i10 = 0;
        for (byte b10 : bArrDigest) {
            char[] cArr2 = x7.b.f14296b;
            cArr[i10] = cArr2[(b10 & 255) >>> 4];
            cArr[i10 + 1] = cArr2[b10 & 15];
            i10 += 2;
        }
        return str2 + ": pkg=" + str + ", sha256=" + new String(cArr) + ", atk=" + z2 + ", ver=12451000.false";
    }
}
