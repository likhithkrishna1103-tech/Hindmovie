package c7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f2553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f2554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f2556e;
    public final Map f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f2557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2558h;
    public final byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f2559j;

    public i(String str, Integer num, n nVar, long j5, long j8, HashMap map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f2552a = str;
        this.f2553b = num;
        this.f2554c = nVar;
        this.f2555d = j5;
        this.f2556e = j8;
        this.f = map;
        this.f2557g = num2;
        this.f2558h = str2;
        this.i = bArr;
        this.f2559j = bArr2;
    }

    public final String a(String str) {
        String str2 = (String) this.f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final h c() {
        h hVar = new h();
        String str = this.f2552a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        hVar.f2544a = str;
        hVar.f2546c = this.f2553b;
        hVar.f2547d = this.f2557g;
        hVar.f2545b = this.f2558h;
        hVar.i = this.i;
        hVar.f2551j = this.f2559j;
        n nVar = this.f2554c;
        if (nVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        hVar.f2548e = nVar;
        hVar.f = Long.valueOf(this.f2555d);
        hVar.f2549g = Long.valueOf(this.f2556e);
        hVar.f2550h = new HashMap(this.f);
        return hVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            String str2 = iVar.f2558h;
            Integer num3 = iVar.f2557g;
            Integer num4 = iVar.f2553b;
            if (this.f2552a.equals(iVar.f2552a) && ((num = this.f2553b) != null ? num.equals(num4) : num4 == null) && this.f2554c.equals(iVar.f2554c) && this.f2555d == iVar.f2555d && this.f2556e == iVar.f2556e && this.f.equals(iVar.f) && ((num2 = this.f2557g) != null ? num2.equals(num3) : num3 == null) && ((str = this.f2558h) != null ? str.equals(str2) : str2 == null) && Arrays.equals(this.i, iVar.i) && Arrays.equals(this.f2559j, iVar.f2559j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f2552a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f2553b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f2554c.hashCode()) * 1000003;
        long j5 = this.f2555d;
        int i = (iHashCode2 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j8 = this.f2556e;
        int iHashCode3 = (((i ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f.hashCode()) * 1000003;
        Integer num2 = this.f2557g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f2558h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.i)) * 1000003) ^ Arrays.hashCode(this.f2559j);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f2552a + ", code=" + this.f2553b + ", encodedPayload=" + this.f2554c + ", eventMillis=" + this.f2555d + ", uptimeMillis=" + this.f2556e + ", autoMetadata=" + this.f + ", productId=" + this.f2557g + ", pseudonymousId=" + this.f2558h + ", experimentIdsClear=" + Arrays.toString(this.i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f2559j) + "}";
    }
}
