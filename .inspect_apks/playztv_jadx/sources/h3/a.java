package h3;

import java.util.Arrays;
import java.util.Objects;
import p1.i0;
import p1.k0;
import p1.m0;
import p1.p;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f5781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q f5782h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f5787e;
    public int f;

    static {
        p pVar = new p();
        pVar.f9967m = m0.p("application/id3");
        f5781g = new q(pVar);
        p pVar2 = new p();
        pVar2.f9967m = m0.p("application/x-scte35");
        f5782h = new q(pVar2);
    }

    public a(String str, String str2, long j5, long j8, byte[] bArr) {
        this.f5783a = str;
        this.f5784b = str2;
        this.f5785c = j5;
        this.f5786d = j8;
        this.f5787e = bArr;
    }

    @Override // p1.k0
    public final q b() {
        String str = this.f5783a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f5782h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f5781g;
            default:
                return null;
        }
    }

    @Override // p1.k0
    public final byte[] c() {
        if (b() != null) {
            return this.f5787e;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f5785c == aVar.f5785c && this.f5786d == aVar.f5786d && Objects.equals(this.f5783a, aVar.f5783a) && Objects.equals(this.f5784b, aVar.f5784b) && Arrays.equals(this.f5787e, aVar.f5787e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f == 0) {
            String str = this.f5783a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f5784b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j5 = this.f5785c;
            int i = (iHashCode2 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
            long j8 = this.f5786d;
            this.f = Arrays.hashCode(this.f5787e) + ((i + ((int) (j8 ^ (j8 >>> 32)))) * 31);
        }
        return this.f;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f5783a + ", id=" + this.f5786d + ", durationMs=" + this.f5785c + ", value=" + this.f5784b;
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
