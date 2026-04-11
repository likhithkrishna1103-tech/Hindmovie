package l3;

import java.util.Arrays;
import java.util.Objects;
import v1.i0;
import v1.k0;
import v1.m0;
import v1.o;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p f7690g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p f7691h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f7695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f7696e;
    public int f;

    static {
        o oVar = new o();
        oVar.f12893m = m0.p("application/id3");
        f7690g = new p(oVar);
        o oVar2 = new o();
        oVar2.f12893m = m0.p("application/x-scte35");
        f7691h = new p(oVar2);
    }

    public a(String str, String str2, long j4, long j7, byte[] bArr) {
        this.f7692a = str;
        this.f7693b = str2;
        this.f7694c = j4;
        this.f7695d = j7;
        this.f7696e = bArr;
    }

    @Override // v1.k0
    public final p a() {
        String str = this.f7692a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f7691h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f7690g;
            default:
                return null;
        }
    }

    @Override // v1.k0
    public final byte[] b() {
        if (a() != null) {
            return this.f7696e;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f7694c == aVar.f7694c && this.f7695d == aVar.f7695d && Objects.equals(this.f7692a, aVar.f7692a) && Objects.equals(this.f7693b, aVar.f7693b) && Arrays.equals(this.f7696e, aVar.f7696e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f == 0) {
            String str = this.f7692a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f7693b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j4 = this.f7694c;
            int i = (iHashCode2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j7 = this.f7695d;
            this.f = Arrays.hashCode(this.f7696e) + ((i + ((int) (j7 ^ (j7 >>> 32)))) * 31);
        }
        return this.f;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f7692a + ", id=" + this.f7695d + ", durationMs=" + this.f7694c + ", value=" + this.f7693b;
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
