package x7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f14427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f14428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14430e;
    public final Map f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f14431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f14432h;
    public final byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f14433j;

    public h(String str, Integer num, l lVar, long j4, long j7, HashMap map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f14426a = str;
        this.f14427b = num;
        this.f14428c = lVar;
        this.f14429d = j4;
        this.f14430e = j7;
        this.f = map;
        this.f14431g = num2;
        this.f14432h = str2;
        this.i = bArr;
        this.f14433j = bArr2;
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

    public final u5.a c() {
        u5.a aVar = new u5.a();
        String str = this.f14426a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        aVar.f12213b = str;
        aVar.f12214c = this.f14427b;
        aVar.f12217g = this.f14431g;
        aVar.f12218h = this.f14432h;
        aVar.i = this.i;
        aVar.f12219j = this.f14433j;
        l lVar = this.f14428c;
        if (lVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        aVar.f12215d = lVar;
        aVar.f12216e = Long.valueOf(this.f14429d);
        aVar.f12212a = Long.valueOf(this.f14430e);
        aVar.f = new HashMap(this.f);
        return aVar;
    }

    public final boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            String str2 = hVar.f14432h;
            Integer num3 = hVar.f14431g;
            Integer num4 = hVar.f14427b;
            if (this.f14426a.equals(hVar.f14426a) && ((num = this.f14427b) != null ? num.equals(num4) : num4 == null) && this.f14428c.equals(hVar.f14428c) && this.f14429d == hVar.f14429d && this.f14430e == hVar.f14430e && this.f.equals(hVar.f) && ((num2 = this.f14431g) != null ? num2.equals(num3) : num3 == null) && ((str = this.f14432h) != null ? str.equals(str2) : str2 == null) && Arrays.equals(this.i, hVar.i) && Arrays.equals(this.f14433j, hVar.f14433j)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f14426a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f14427b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f14428c.hashCode()) * 1000003;
        long j4 = this.f14429d;
        int i = (iHashCode2 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j7 = this.f14430e;
        int iHashCode3 = (((i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.f.hashCode()) * 1000003;
        Integer num2 = this.f14431g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f14432h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.i)) * 1000003) ^ Arrays.hashCode(this.f14433j);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f14426a + ", code=" + this.f14427b + ", encodedPayload=" + this.f14428c + ", eventMillis=" + this.f14429d + ", uptimeMillis=" + this.f14430e + ", autoMetadata=" + this.f + ", productId=" + this.f14431g + ", pseudonymousId=" + this.f14432h + ", experimentIdsClear=" + Arrays.toString(this.i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f14433j) + "}";
    }
}
